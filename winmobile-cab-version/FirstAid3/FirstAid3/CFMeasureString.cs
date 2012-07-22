using System;
using System.Text;
using System.Runtime.InteropServices;
using System.Drawing;

using System.Collections.Generic;


namespace FirstAid3
{
 public class CFMeasureString
  {
    private struct Rect
    {
        public int Left, Top, Right, Bottom;
        public Rect(Rectangle r)
        {
          this.Left = r.Left;
          this.Top = r.Top;
          this.Bottom = r.Bottom;
          this.Right = r.Right;
        }
    }

    [DllImport("coredll.dll")]
    static extern int DrawText(IntPtr hdc, string lpStr, int nCount, ref Rect lpRect, int wFormat);
    private const int DT_CALCRECT = 0x00000400;
    private const int DT_WORDBREAK = 0x00000010;
    private const int DT_EDITCONTROL = 0x00002000;

    static public Size MeasureString(Graphics gr, string text, Rectangle rect, bool textboxControl)
    {
        Rect bounds = new Rect(rect);
        IntPtr hdc = gr.GetHdc();
        int flags = DT_CALCRECT|DT_WORDBREAK;
        if (textboxControl) flags |= DT_EDITCONTROL;
        DrawText(hdc, text, text.Length, ref bounds, flags);
        gr.ReleaseHdc(hdc);
        return new Size(bounds.Right - bounds.Left, bounds.Bottom - bounds.Top + (textboxControl? 6 : 0));
    }
  }
}