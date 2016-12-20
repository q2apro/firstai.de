#!/bin/bash -e
for TEMPLATE in TEMPLATE_*; do
	DESTPATTERN=${TEMPLATE#TEMPLATE_}
	DELETEPATTERN=${DESTPATTERN//XX/*}
	rm $DELETEPATTERN 2>/dev/null || true
	[ "$1" == "clean" ] && continue
	echo $DESTPATTERN
	for LANGFILE in lang-*.js; do
		LANG=${LANGFILE#lang-}
		LANG=${LANG%.js}
		TITLE=`head -1 lang-$LANG.js | sed 's#//:##'`
		echo -- $LANG -- $TITLE
		sed "s/XXTITLEXX/$TITLE/;s/XX/$LANG/" < $TEMPLATE >${DESTPATTERN/XX/$LANG}
	done
done
