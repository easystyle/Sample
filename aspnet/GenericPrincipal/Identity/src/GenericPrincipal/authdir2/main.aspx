<%@ Page Language="C#" %>
<html>
    <head runat="server">
        <script runat="server">
            void Page_Load(object sender, EventArgs e)
            {
                Title = "main";
            }
            void logout_Click(object sender, EventArgs e)
            {
                FormsAuthentication.SignOut();
                FormsAuthentication.RedirectToLoginPage();
            }
        </script>
    </head>
    <body>
        <form id="form1" runat="server">
            <div>
                <asp:Label id="label1" Text="main" runat="server" />
            </div>
            <div>
                <asp:Button id="logout" Text="Logout" OnClick="logout_Click" runat="server" />
            </div>
            <div>
                <%
                  Type identityType = User.Identity.GetType();
            	  string strIdentityType = identityType.ToString();
                  Response.Write("strIdentityType = " + strIdentityType);
                %>
            </div>
        </form>
    </body>
</html>