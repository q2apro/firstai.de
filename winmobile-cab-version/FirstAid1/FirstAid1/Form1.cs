using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace FirstAid1 {
    public partial class Form1 : Form {
       //string path = "";
       //Bitmap backImage;

       ListViewItem test2 = new ListViewItem("Disclaimer + Info"); //"1. Software\nFirst Aid on your Mobile\nVersion: j3.0\nRelease: 2008-12-24\nCopyright: Kai Kajus Noack\nLicence: Creative Commons BY-NC-ND\n\nFirst Aid Illustrations © Med4Teens\n\nThis program is supposed to give information on first aid. However, it does not represent a substitute to a first aid course. It rather serves you refreshing your already acquired knowledge.\n\n2. Disclaimer\nPlease note that I take no responsibility for consequences resulting from the use of the software.\nANY LIABILITY IS EXCLUDED!\nUSE AT YOUR OWN RISK!\n\nIn all emergencies, please seek professional help immediately.\n\n3. Project Development\nThe program is supposed to become multilingual. Voluntary Translators needed!!\n\nFurther information is available on the Internet www.firstai.de or write an email to: info@firstai.de\n\nTo save one life is to have saved the world.");

        public Form1() {
            InitializeComponent();
            menu.Items.Add(test2);
            Console.WriteLine("HIT");
            // load image
            //backImage = new Bitmap(path + @"\BMP\background.bmp");
        }

        private void menuItem1_Click(object sender, EventArgs e) {
           Application.Exit(); 
        }


        protected override void OnPaint(PaintEventArgs e)
        {

/*            // Create string to draw.
            string drawString = "Hello World";

            // Create font and brush.
            Font drawFont = new Font("Arial", 10, FontStyle.Regular);
            SolidBrush drawBrush = new SolidBrush(Color.Black);

            // Create point for upper-left corner of drawing.
            float x = 10.0F;
            float y = 10.0F;

            // Draw string to screen.
            e.Graphics.DrawString(drawString, drawFont, drawBrush, x, y);
 */

        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

            // Check if the user presses the action key
            /*protected override void OnKeyDown(KeyEventArgs e) {
               switch(e.KeyCode) {
                  case Keys.Return:
                     MessageBox.Show("You selected item " + 
                       this.SelectedIndex.ToString(),
                        "Item selected", 
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Asterisk,
                        MessageBoxDefaultButton.Button1);
                     break;
               }

               base.OnKeyDown(e);
            }*/

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

    }
}