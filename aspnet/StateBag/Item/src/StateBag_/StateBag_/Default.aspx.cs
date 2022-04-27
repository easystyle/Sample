using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

namespace StateBag_
{
    public partial class _Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                ViewState["data1"] = (object)"ABCDE";
                ViewState["data2"] = (object)"FGHIJ";
            }
            label1.Text = (string)ViewState["data1"];
            label2.Text = (string)ViewState["data2"];
        }
    }
}