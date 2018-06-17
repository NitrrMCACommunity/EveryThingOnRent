
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;

public class HttpResponseHandler {
	public static boolean isLogin(HttpServletRequest req)
	{
		HttpSession ses=req.getSession(false);
		
		if(ses!=null)
			return true;
					return false;
	}
	public static void displayHome(PrintWriter out,User u)
	{
		HttpResponseHandler.profileUpperView(out, u);
		HttpResponseHandler.profile(out, u.getName());
		HttpResponseHandler.bottomView(out);
	}
	public static void topViews(HttpServletRequest req,PrintWriter out)
	{
		if(HttpResponseHandler.isLogin(req))
		{
			HttpSession session=req.getSession();
			String userid=(String)session.getAttribute("username");
			User u=Dbopr.getUser(userid);
			HttpResponseHandler.profileUpperView(out, u);
		}
		else
		{
			HttpResponseHandler.topViewForOthers(out);
		}
	}
	public static void newFeeds(HttpServletRequest request,PrintWriter out)
	{
		int page;
		String pageid=request.getParameter("page");
		if(pageid==null)
			page=1;
		else
			page=Integer.parseInt(pageid);
		if(page<1)
			page=1;
		int totalpage=Dbitemopr.totalRecords();
		if(totalpage%6!=0) 
		totalpage=(totalpage/6)+1;
		else
			totalpage=(totalpage/6);
		if(page>totalpage)
			out.print("<h3><font color=blue>No more product...<font></h3>");
		ShowResult.displayRecords(out, page);
		out.println(" 				  <div class=\"clear\"></div>\r\n" + 
				"			    	</a></div>\r\n" + 
				"				  <div class=\"clear\"></div>\r\n" + 
				"			    </div>\r\n" + 
				"			  </div>\r\n" + 
				"			 </div>\r\n" + 
				"        </div>");
		out.println(" <center>\r\n" + 
				"		<font size=\"4\" color=blue>"+
				"		<a href=\"Index?page="+(page-1)+"\" class=\"previous\">&laquo; Previous</a>");
		for(int i=1;i<=totalpage;i++)
			out.println("<a href=\"Index?page="+i+"\" class=\"next\">"+i+"</a>");
		out.println("<a href=\"Index?page="+(page+1)+"\" class=\"next\">Next &raquo;</a>\r\n" + 
				"</font>\r\n" + 
				"</center>");
		out.print(" <div class=\"index-banner\">\r\n" + 
				"       	  <div class=\"wmuSlider example1\" style=\"height: 560px;\">\r\n" + 
				"			  <div class=\"wmuSliderWrapper\">\r\n" + 
				"				  <article style=\"position: relative; width: 100%; opacity: 1;\"> \r\n" + 
				"				   	<div class=\"banner-wrap\">\r\n" + 
				"					   	<div class=\"slider-left\">\r\n" + 
				"							<img src=\"images/banner1.jpg\" alt=\"\"/> \r\n" + 
				"						</div>\r\n" + 
				"						 <div class=\"slider-right\">\r\n" + 
				"						    <h1>Product</h1>\r\n" + 
				"						    <h2>Advertisement</h2>\r\n" + 
				"						    <p>Product Description</p>\r\n" + 
				"						    <div class=\"btn\"><a href=\"shop.html\">Order</a></div>\r\n" + 
				"						 </div>\r\n" + 
				"						 <div class=\"clear\"></div>\r\n" + 
				"					 </div>\r\n" + 
				"					</article>\r\n" + 
				"				   <article style=\"position: absolute; width: 100%; opacity: 0;\"> \r\n" + 
				"				   	 <div class=\"banner-wrap\">\r\n" + 
				"					   	<div class=\"slider-left\">\r\n" + 
				"							<img src=\"images/banner2.jpg\" alt=\"\"/> \r\n" + 
				"						</div>\r\n" + 
				"						 <div class=\"slider-right\">\r\n" + 
				"						    <h1>Product</h1>\r\n" + 
				"						    <h2>Advertisement</h2>\r\n" + 
				"						    <p>Product Description</p>\r\n" + 
				"						    <div class=\"btn\"><a href=\"shop.html\">Order</a></div>\r\n" + 
				"						 </div>\r\n" + 
				"						 <div class=\"clear\"></div>\r\n" + 
				"					 </div>\r\n" + 
				"				   </article>\r\n" + 
				"				   <article style=\"position: absolute; width: 100%; opacity: 0;\">\r\n" + 
				"				   	<div class=\"banner-wrap\">\r\n" + 
				"					   	<div class=\"slider-left\">\r\n" + 
				"							<img src=\"images/banner1.jpg\" alt=\"\"/> \r\n" + 
				"						</div>\r\n" + 
				"						 <div class=\"slider-right\">\r\n" + 
				"						    <h1>Product</h1>\r\n" + 
				"						    <h2>Advertisement</h2>\r\n" + 
				"						    <p>Product Description</p>\r\n" + 
				"						    <div class=\"btn\"><a href=\"shop.html\">Order</a></div>\r\n" + 
				"						 </div>\r\n" + 
				"						 <div class=\"clear\"></div>\r\n" + 
				"					 </div>\r\n" + 
				"				   </article>\r\n" + 
				"				   <article style=\"position: absolute; width: 100%; opacity: 0;\">\r\n" + 
				"				   	<div class=\"banner-wrap\">\r\n" + 
				"					   	<div class=\"slider-left\">\r\n" + 
				"							<img src=\"images/banner2.jpg\" alt=\"\"/> \r\n" + 
				"						</div>\r\n" + 
				"						 <div class=\"slider-right\">\r\n" + 
				"						    <h1>Product</h1>\r\n" + 
				"						    <h2>Advertisement</h2>\r\n" + 
				"						    <p>Product</p>\r\n" + 
				"						    <div class=\"btn\"><a href=\"shop.html\">Order</a></div>\r\n" + 
				"						 </div>\r\n" + 
				"						 <div class=\"clear\"></div>\r\n" + 
				"					 </div>\r\n" + 
				"				   </article>\r\n" + 
				"				   <article style=\"position: absolute; width: 100%; opacity: 0;\"> \r\n" + 
				"				   	 <div class=\"banner-wrap\">\r\n" + 
				"					   	<div class=\"slider-left\">\r\n" + 
				"							<img src=\"images/banner1.jpg\" alt=\"\"/> \r\n" + 
				"						</div>\r\n" + 
				"						 <div class=\"slider-right\">\r\n" + 
				"						    <h1>Product</h1>\r\n" + 
				"						    <h2>Advertisement</h2>\r\n" + 
				"						    <p>Product</p>\r\n" + 
				"						    <div class=\"btn\"><a href=\"shop.html\">Order</a></div>\r\n" + 
				"						 </div>\r\n" + 
				"						 <div class=\"clear\"></div>\r\n" + 
				"					 </div>\r\n" + 
				"			      </article>\r\n" + 
				"				</div>\r\n" + 
				"                <a class=\"wmuSliderPrev\">Previous</a><a class=\"wmuSliderNext\">Next</a>\r\n" + 
				"                <ul class=\"wmuSliderPagination\">\r\n" + 
				"                	<li><a href=\"#\" class=\"\">0</a></li>\r\n" + 
				"                	<li><a href=\"#\" class=\"\">1</a></li>\r\n" + 
				"                	<li><a href=\"#\" class=\"wmuActive\">2</a></li>\r\n" + 
				"                	<li><a href=\"#\">3</a></li>\r\n" + 
				"                	<li><a href=\"#\">4</a></li>\r\n" + 
				"                  </ul>\r\n" + 
				"                 <a class=\"wmuSliderPrev\">Previous</a><a class=\"wmuSliderNext\">Next</a><ul class=\"wmuSliderPagination\"><li><a href=\"#\" class=\"wmuActive\">0</a></li><li><a href=\"#\" class=\"\">1</a></li><li><a href=\"#\" class=\"\">2</a></li><li><a href=\"#\" class=\"\">3</a></li><li><a href=\"#\" class=\"\">4</a></li></ul></div>\r\n" + 
				"            	 <script src=\"js/jquery.wmuSlider.js\"></script> \r\n" + 
				"				 <script type=\"text/javascript\" src=\"js/modernizr.custom.min.js\"></script> \r\n" + 
				"						<script>\r\n" + 
				"       						 $('.example1').wmuSlider();         \r\n" + 
				"   						</script> 	           	      \r\n" + 
				"             </div>\r\n" + 
				"             <div class=\"main\">\r\n" + 
				"                <div class=\"wrap\">\r\n" + 
				"             	  <div class=\"content-top\">\r\n" + 
				"             		<div class=\"lsidebar span_1_of_c1\">\r\n" + 
				"					  <p>Share</p>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"cont span_2_of_c1\">\r\n" + 
				"					  <div class=\"social\">	\r\n" + 
				"					     <ul>	\r\n" + 
				"						  <li class=\"facebook\"><a href=\"www.facebook.com\"><span> </span></a><div class=\"radius\"> <img src=\"images/radius.png\"><a href=\"#\"> </a></div><div class=\"border hide\"><p class=\"num\">1.51K</p></div></li>\r\n" + 
				"						 </ul>\r\n" + 
				"			   		   </div>\r\n" + 
				"					   <div class=\"social\">	\r\n" + 
				"						   <ul>	\r\n" + 
				"							  <li class=\"twitter\"><a href=\"www.tiwtter.com\"><span> </span></a><div class=\"radius\"> <img src=\"images/radius.png\"></div><div class=\"border hide\"><p class=\"num\">1.51K</p></div></li>\r\n" + 
				"						  </ul>\r\n" + 
				"			     		</div>\r\n" + 
				"						 <div class=\"social\">	\r\n" + 
				"						   <ul>	\r\n" + 
				"							  <li class=\"google\"><a href=\"www.google.com\"><span> </span></a><div class=\"radius\"> <img src=\"images/radius.png\"></div><div class=\"border hide\"><p class=\"num\">1.51K</p></div></li>\r\n" + 
				"						   </ul>\r\n" + 
				"			    		 </div>\r\n" + 
				"						 <div class=\"social\">	\r\n" + 
				"						   <ul>	\r\n" + 
				"							  <li class=\"dot\"><a href=\"#\"><span> </span></a><div class=\"radius\"> <img src=\"images/radius.png\"></div><div class=\"border hide\"><p class=\"num\">1.51K</p></div></li>\r\n" + 
				"						  </ul>\r\n" + 
				"			     		</div>\r\n" + 
				"						<div class=\"clear\"> </div>\r\n" + 
				"					  </div>\r\n" + 
				"					  <div class=\"clear\"></div>			\r\n" + 
				"				   </div>");
	}
	public static void profile(PrintWriter out,String msg)
	{
		out.print(" <div class=\"register_account\">\r\n" + 
				"          	<div class=\"wrap\">\r\n" + 
				"    	      <h3 class=\"title\"><font color =\"blue\">"+msg+"<br/>\r\n"
						+ "<a href=ShowItem?pid=pics>New feeds</a>\r\n"
						+ "</font></h3>\r\n" + 
				"    		  \r\n" + 
				"		         \r\n" + 
				"		         \r\n" + 
				"		         <div class=\"clear\"></div>\r\n" + 
				"		    </form>\r\n" + 
				"    	  </div> \r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"footer\">\r\n" + 
				"       	  <div class=\"footer-top\">\r\n" + 
				"       		<div class=\"wrap\">\r\n" + 
				"       			   <div class=\"col_1_of_footer-top span_1_of_footer-top\">\r\n" + 
				"				  	 <ul class=\"f_list\">\r\n" + 
				"				  	 	<li><img src=\"images/f_icon.png\" alt=\"\"/><span class=\"delivery\">Free delivery </span></li>\r\n" + 
				"				  	 </ul>\r\n" + 
				"				   </div>\r\n" + 
				"				   <div class=\"col_1_of_footer-top span_1_of_footer-top\">\r\n" + 
				"				  	<ul class=\"f_list\">\r\n" + 
				"				  	 	<li><img src=\"images/f_icon1.png\" alt=\"\"/><span class=\"delivery\">Customer Service :<span class=\"orange\">(+91) 7352286834 (freephone)</span></span></li>\r\n" + 
				"				  	 </ul>\r\n" + 
				"				   </div>\r\n" + 
				"				   <div class=\"col_1_of_footer-top span_1_of_footer-top\">\r\n" + 
				"				  	<ul class=\"f_list\">\r\n" + 
				"				  	 	<li><img src=\"images/f_icon2.png\" alt=\"\"/><span class=\"delivery\">Fast delivery</span></li>\r\n" + 
				"				  	 </ul>\r\n" + 
				"				   </div>\r\n" + 
				"				  <div class=\"clear\"></div>\r\n" + 
				"			 </div>\r\n" + 
				"       	 </div>");
	}
	protected static void varifyOTP(String userid,PrintWriter out,String msg)
	{
		HttpResponseHandler.topViewForOthers(out);
		out.print("<div class=\"register_account\">\r\n" + 
				"          	<div class=\"wrap\">\r\n" + 
				"    	      <h4 class=\"title\"></h4>\r\n" + 
				"    		   <form action=\"OTP\" method=\"POST\">\r\n" + 
				"    			 <div class=\"col_1_of_2 span_1_of_2\">\r\n" + 
				"                                    \r\n" + 
				"                                      <font color=\"red\">"+msg+"</font> \r\n" + 
				"					<input type=\"hidden\"name=\"userid\"value='"+userid+"'>\r\n" + 
				"		   			 <div><input type=\"text\"name=\"otp\" value=\"Enter OTP\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Enter OTP';}\"></div>\r\n" + 
				"		    			\r\n" + 
				"		    	 </div>\r\n" + 
				"		          \r\n" + 
				"		       <br/><br/><br/><br/>\r\n" + 
				"                        <button class=\"grey\">Submit</button>\r\n" + 
				"		         <p class=\"terms\"><a href=\"#\">Resend &amp; OTP</a>.</p>\r\n" + 
				"		         <div class=\"clear\"></div>\r\n" + 
				"		    </form>\r\n" + 
				"    	  </div> \r\n" + 
				"        </div>");
		HttpResponseHandler.bottomView(out);
	}
	public static void printMsg(PrintWriter out,String msg)
	{
		HttpResponseHandler.topViewForOthers(out);
		out.print("<div class=\"register_account\">\r\n" + 
				"          	<div class=\"wrap\">\r\n" + 
				"    	      <h4 class=\"title\"><font color=\"red\">"+msg+"\r\n" + 
				"    		  <br/>\r\n" +
				"		         \r\n" + 
				"		         <div class=\"clear\"></div>\r\n" + 
				"		    </form>\r\n" + 
				"    	  </div> \r\n" + 
				"        </div>");
		HttpResponseHandler.bottomView(out);
	}
	public static void topViewForOthers(PrintWriter out)
	{
		out.print("<!DOCTYPE HTML>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Aavartan NIT Raipur</title>\r\n" +
				" <meta name=\"google-signin-client_id\" content=\"YOUR_CLIENT_ID.apps.googleusercontent.com\">\r\n"+
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
				"<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n" + 
				"<link href='http://fonts.googleapis.com/css?family=Open+Sans:Rs400' rel='stylesheet' type='text/css'>\r\n" + 
				"<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				"        $(document).ready(function() {\r\n" + 
				"            $(\".dropdown img.flag\").addClass(\"flagvisibility\");\r\n" + 
				"\r\n" + 
				"            $(\".dropdown dt a\").click(function() {\r\n" + 
				"                $(\".dropdown dd ul\").toggle();\r\n" + 
				"            });\r\n" + 
				"                        \r\n" + 
				"            $(\".dropdown dd ul li a\").click(function() {\r\n" + 
				"                var text = $(this).html();\r\n" + 
				"                $(\".dropdown dt a span\").html(text);\r\n" + 
				"                $(\".dropdown dd ul\").hide();\r\n" + 
				"                $(\"#result\").html(\"Selected value is: \" + getSelectedValue(\"sample\"));\r\n" + 
				"            });\r\n" + 
				"                        \r\n" + 
				"            function getSelectedValue(id) {\r\n" + 
				"                return $(\"#\" + id).find(\"dt a span.value\").html();\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            $(document).bind('click', function(e) {\r\n" + 
				"                var $clicked = $(e.target);\r\n" + 
				"                if (! $clicked.parents().hasClass(\"dropdown\"))\r\n" + 
				"                    $(\".dropdown dd ul\").hide();\r\n" + 
				"            });\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"            $(\"#flagSwitcher\").click(function() {\r\n" + 
				"                $(\".dropdown img.flag\").toggleClass(\"flagvisibility\");\r\n" + 
				"            });\r\n" + 
				"        });\r\n" + 
				"     </script>\r\n" + 
				"<!-- start menu -->     \r\n" + 
				"<link href=\"css/megamenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n" + 
				"<script type=\"text/javascript\" src=\"js/megamenu.js\"></script>\r\n" + 
				"<script>$(document).ready(function(){$(\".megamenu\").megamenu();});</script>\r\n" + 
				"<!-- end menu -->\r\n" + 
				"<!-- top scrolling -->\r\n" + 
				"<script type=\"text/javascript\" src=\"js/move-top.js\"></script>\r\n" + 
				"<script type=\"text/javascript\" src=\"js/easing.js\"></script>\r\n" + 
				"   <script type=\"text/javascript\">\r\n" + 
				"		jQuery(document).ready(function($) {\r\n" + 
				"			$(\".scroll\").click(function(event){		\r\n" + 
				"				event.preventDefault();\r\n" + 
				"				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);\r\n" + 
				"			});\r\n" + 
				"		});\r\n" + 
				"	</script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"  <div class=\"header-top\">\r\n" + 
				"	 <div class=\"wrap\"> \r\n" + 
				"		<div class=\"logo\">\r\n" + 
				"			<a href=\"Index\"><img src=\"images/rent.jpg\" alt=\"\"/>\r\n" + 
				"	    </div>\r\n" + 
				"	    <div class=\"cssmenu\">\r\n" + 
				"		   <ul>\r\n" + 
				"			 <li class=\"active\"><a href=\"Registration\">Register</a></li> \r\n" + 
				"			 <li><a href=\"login.html\">Login</a></li> \r\n" + 
				"			  <li><a href=\"Search\">Search</a></li> \r\n" + 
				"		\r\n" + 
				"		   </ul>\r\n" + 
				"		</div>\r\n" + 
				"		<ul class=\"icon2 sub-icon2 profile_img\">\r\n" + 
				"			<li><a class=\"active-icon c2\" href=\"Index\"> </a>\r\n" + 
				"				<ul class=\"sub-icon2 list\">\r\n" + 
				"					<li><h3>My Cart</h3><a href=\"\"></a></li>\r\n" + 
				"					<li><p><ul><li>My cart product1</l1></ul> <a href=\"#\">Clear Cart</a></p></li>\r\n" + 
				"				</ul>\r\n" + 
				"			</li>\r\n" + 
				"		</ul>\r\n" + 
				"		<div class=\"clear\"></div>\r\n" + 
				" 	</div>\r\n" + 
				"   </div>\r\n" + 
				"   <div class=\"header-bottom\">\r\n" + 
				"   	<div class=\"wrap\">\r\n" + 
				"   		<!-- start header menu -->\r\n" + 
				"		<ul class=\"megamenu skyblue\">\r\n" + 
				"		    <li><a class=\"color1\" href=\"Index\">Home</a></li>\r\n" + 
				"			<li class=\"grid\"><a class=\"color2\" href=\"#\">Books</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Engneering</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=mechanical\">Machanical</a></li>\r\n" + 
				"									<li><a href=\"Search?key=civil\">Civil</a></li>\r\n" + 
				"									<li><a href=\"Search?key=chemical\">Chemical</a></li>\r\n" + 
				"									<li><a href=\"Search?key=electronix\">Electronix</a></li>\r\n" + 
				"									<li><a href=\"Search?key=computer science\">Computer Science</a></li>\r\n" + 
				"	\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4 class=\"top\">Medical</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=mbbs\">MBBS</a></li>\r\n" + 
				"									<li><a href=\"Search?key=bds\">BDS</a></li>\r\n" + 
				"									<li><a href=\"Search?key=b pharma\">B Pharma</a></li>\r\n" + 
				"									<li><a href=\"Search?key=m pharma\">M Pharma</a></li>\r\n" + 
				"								\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Management</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=human resource\">Human Resource</a></li>\r\n" + 
				"									<li><a href=\"Search?key=facility management\">Facility Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=operation management\">Operation Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=system management\">System Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=financial management\">Financial Management</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Novels</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=human resource\">Human Resource</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Facility Management\">Facility Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Operation Management\">Operation Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=System Management\">System Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=System Management\">Financial Management</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<img src=\"images/books.jpg\" height='200px' width='200px' alt=\"\"/>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				</li>\r\n" + 
				"  			   <li class=\"active grid\"><a class=\"color4\" href=\"#\">Vehicles</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Cycle</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Mountain Cycle\">Mountain Cycle</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Racing Cycle\">Racing Cycle</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Two Wheeler</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Scooty\">Scooty</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Bike\">Bike</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"							<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Four Wheeler</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Car\">Car</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Transport Vehicles\">Transport Vehicles</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"						 <div class=\"h_nav\">\r\n" + 
				"						   <img src=\"images/cycle.png\" height='200px' width='200px'alt=\"\"/>\r\n" + 
				"						 </div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"					</div>\r\n" + 
				"					</div>\r\n" + 
				"    			</li>				\r\n" + 
				"				<li><a class=\"color5\" href=\"#\">Real Estates</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Flats</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=1 bhk flat\">1 BHK Flat</a></li>\r\n" + 
				"									<li><a href=\"Search?key=2 bhk flat\">2 BHK Flat</a></li>\r\n" + 
				"									<li><a href=\"Search?key=3 bhk flat\">3 BHK Flat</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4 class=\"top\">Rooms</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=single room\">Single Room</a></li>\r\n" + 
				"									<li><a href=\"Search?key=double room\">Double Room</a></li>\r\n" + 
				"									<li><a href=\"Search?key=family room\">Family  Room</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<img src=\"images/house.jpg\" height='200px' width='200px'alt=\"\"/>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				</li>\r\n" + 
				"				<li><a class=\"color7\" href=\"#\">Party Wears</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Man</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=kurta pyjama\">Kurta Pyjama</a></li>\r\n" + 
				"									<li><a href=\"Search?key=sherwani\">Sherwani</a></li>\r\n" + 
				"									<li><a href=\"Search?key=mens grooming\">Mens Grooming</a></li>\r\n" + 
				"									<li><a href=\"Search?key=party suits\">Party suits</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Woman</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=ethnic wear\">Ethnic Wear</a></li>\r\n" + 
				"									<li><a href=\"Search?key=beauty grooming\">Beauty & Grooming</a></li>\r\n" + 
				"									<li><a href=\"Search?key=jewellery\">Jewellery</a></li>\r\n" + 
				"									<li><a href=\"Search?key=International Brand\">International Brand</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Accessories\">Accessories</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"					\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<img src=\"images/dress.jpg\" height='200px' width='200px' alt=\"\"/>\r\n" + 
				"					</div>\r\n" + 
				"    				</div>\r\n" + 
				"				</li>\r\n" + 
				"				\r\n" + 
				"				<li><a class=\"color7\" href=\"#\">Electronics</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Fan</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Stand Fan\">Stand Fan</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Table Fan\">Table Fan</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Fan in Bulk\">Fan in Bulks for Function</a></li>\r\n" + 
				"									<li><a href=\"Search?key=coolers\">Coolers</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4> Hardware</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Printer\">Printer</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Scanner\">Scanner</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Ploatter\">Ploatter</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Computer Hardware\">Others</a></li>\r\n" + 
				"								\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"							<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Others</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Camera\">Digital Cameras</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Electronic Function\">Electronic Product for Function</a></li>\r\n" + 
				"								\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"					\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<img src=\"images/dress.jpg\" height='200px' width='200px' alt=\"\"/>\r\n" + 
				"					</div>\r\n" + 
				"    				</div>\r\n" + 
				"				</li>\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				<li><a class=\"color6\" href=\"aboutus.html\">About Us</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"									\r\n" + 
				"											\r\n" + 
				"						<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				</li>\r\n" + 
				"				<li><a class=\"color8\" href=\"#\">Contact Us</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h2>For any technical queries, Contact Helpdesk No's: +91-8407095037, \r\n" + 
				"								+91-9634064603, +91-7352286834 (from 10:30AM to 5:00PM Monday to Saturday working days only) \r\n" + 
				"								E-mail: afsaredrisy@gmail.com,basantkumar562@gmail.com</h3>\r\n" + 
				"								</div>							\r\n" + 
				"						</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				</li>\r\n" + 
				"						<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"					</div>\r\n" + 
				"    				</div>\r\n" + 
				"				</li>\r\n" + 
				"				\r\n" + 
				"		   </ul>\r\n" + 
				"		   <div class=\"clear\"></div>\r\n" + 
				"     	</div>\r\n" + 
				"       </div>");
	}
	public static void bottomView(PrintWriter out)
	{
		out.print(" <div class=\"footer\">\r\n" + 
				"       	  <div class=\"footer-top\">\r\n" + 
				"       		<div class=\"wrap\">\r\n" + 
				"				   <div class=\"col_1_of_footer-top span_1_of_footer-top\">\r\n" + 
				"				  	<ul class=\"f_list\">\r\n" + 
				"					 	<li><img src=\"images/f_icon1.png\" alt=\"\"/><span class=\"delivery\">Customer Service :<span class=\"orange\">(+91) 7352286834 (freephone)</span></span></li>\r\n" + 
				"				  	 </ul>\r\n" + 
				"				   </div>				  \r\n" + 
				"				  <div class=\"clear\"></div>\r\n" + 
				"			 </div>\r\n" + 
				"       	 </div>\r\n" + 
				"       	 <div class=\"footer-middle\">\r\n" + 
				"       	 	<div class=\"wrap\">\r\n" + 
				"       	 		<div class=\"section group\">\r\n" + 
				"				<div class=\"col_1_of_middle span_1_of_middle\">\r\n" + 
				"					<dl id=\"sample\" class=\"dropdown\">\r\n" + 
				"			        <dt><a href=\"#\"><span>Please Select a States</span></a></dt>\r\n" + 
				"			        <dd>\r\n" + 
				"			            <ul>\r\n" + 
				"			                <li><a href=\"#\">Andaman & Nicobar <span class=\"value\">AN</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Andhra Pradesh <span class=\"value\">AP</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Arunachal Pradesh <span class=\"value\">AR</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Assam <span class=\"value\">AS</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Bihar <span class=\"value\">BH</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Chandigarh <span class=\"value\">CH</span></a></li>\r\n" + 
				"							 <li><a href=\"#\">Chhatisgarh<span class=\"value\">CG</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Delhi <span class=\"value\">DL</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Goa <span class=\"value\">GO</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Gujarat <span class=\"value\">GU</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Haryana<span class=\"value\">HR</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Himachal Pradesh<span class=\"value\">HP</span></a></li>\r\n" + 
				"							 <li><a href=\"#\">Jammu & Kashmir <span class=\"value\">JK</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Jharkhand<span class=\"value\">JH</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Utter Pardesh<span class=\"value\">UP</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Karnataka <span class=\"value\">KR</span></a></li>\r\n" + 
				"			                \r\n" + 
				"			                <li><a href=\"#\">Madhya Pardesh<span class=\"value\">MP</span></a></li> \r\n" + 
				"							<li><a href=\"#\">Chhatishgarh<span class=\"value\">CH</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Jharkhand<span class=\"value\">JH</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Utter Pardesh<span class=\"value\">UP</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Mharasta<span class=\"value\">MH</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">West Bangal<span class=\"value\">WB</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Madhya Pardesh<span class=\"value\">MP</span></a></li>\r\n" + 
				"							 <li><a href=\"#\">Chhatishgarh<span class=\"value\">CH</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Jharkhand<span class=\"value\">JH</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Uttar Pardesh<span class=\"value\">UP</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Maharasta<span class=\"value\">MH</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">West Bangal<span class=\"value\">WB</span></a></li>\r\n" + 
				"			                <li><a href=\"#\">Madhya Pardesh<span class=\"value\">MP</span></a></li>\r\n" + 
				"			            </ul>\r\n" + 
				"			         </dd>\r\n" + 
				"   				    </dl>\r\n" + 
				"   				 </div>\r\n" + 
				"				<div class=\"col_1_of_middle span_1_of_middle\">\r\n" + 
				"					<ul class=\"f_list1\">\r\n" + 
				"						<li><span class=\"m_8\">Search Item</span>\r\n" + 
				"						<div class=\"search\">	  \r\n" + 
				"							<input type=\"text\" name=\"s\" class=\"textbox\" value=\"Search\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Search';}\">\r\n" + 
				"							<input type=\"submit\" value=\"Subscribe\" id=\"submit\" name=\"submit\">\r\n" + 
				"							<div id=\"response\"> </div>\r\n" + 
				"			 			</div><div class=\"clear\"></div>\r\n" + 
				"			 		    </li>\r\n" + 
				"					</ul>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"clear\"></div>\r\n" + 
				"			   </div>\r\n" + 
				"       	 	</div>\r\n" + 
				"       	 </div>\r\n" + 
				"       	 <div class=\"footer-bottom\">\r\n" + 
				"       	 	<div class=\"wrap\">\r\n" + 
				"       	 		<div class=\"section group\">\r\n" + 
				"				<div class=\"col_1_of_5 span_1_of_5\">\r\n" + 
				"					<h3 class=\"m_9\">Books</h3>\r\n" + 
				"					<ul class=\"sub_list\">\r\n" + 
				"						<h4 class=\"m_10\">Engneering</h4>\r\n" + 
				"					    <li><a href=\"Search?key=Mechanical\">Mechanical</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=Civil\">Civil</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=Chemical\">Chemical</a></li>\r\n" + 
				"			           <li><a href=\"Search?key=Electronix\">Electronix</a></li>\r\n" + 
				"   					 <li><a href=\"Search?key=Computer\">Computer Science</a></li>\r\n" + 
				"					 </ul>\r\n" + 
				"			             <ul class=\"sub_list\">\r\n" + 
				"				            <h4 class=\"m_10\">Medical</h4>\r\n" + 
				"				            <li><a href=\"Search?key=MBBS\">MBBS</a></li>\r\n" + 
				"				            <li><a href=\"Search?key=BDS\">BDS</a></li>\r\n" + 
				"				            <li><a href=\"Search?key=B Pharma\">B Pharma</a></li>\r\n" + 
				"				         </ul>\r\n" + 
				"				         <ul class=\"sub_list\">\r\n" + 
				"				            <h4 class=\"m_10\">Management</h4>\r\n" + 
				"				            <li><a href=\"Search?key=Human Resource\">Human Resource </a></li>\r\n" + 
				"				            <li><a href=\"Search?key=Facility Managment\">Facility Managment</a></li>\r\n" + 
				"				            <li><a href=\"Search?key=Operation Managment\">Operation Manegement</a></li>\r\n" + 
				"							 <li><a href=\"Search?key=System Managment\">System Management</a></li>\r\n" + 
				"							  <li><a href=\"Search?key=Financial Management\">Financial Management </a></li>\r\n" + 
				"				         </ul>\r\n" + 
				"				        <ul class=\"sub_list\">\r\n" + 
				"				            <h4 class=\"m_10\">Novels</h4>\r\n" + 
				"				            <li><a href=\"Search?key=Romance novel\">Romance novel</a></li>\r\n" + 
				"				            <li><a href=\"Search?key=War novel\">War novel</a></li>\r\n" + 
				"				            <li><a href=\"Search?key=Biographical\">Biographical novel</a></li>\r\n" + 
				"							 <li><a href=\"Search?key=Social novel\">Social novel</a></li>\r\n" + 
				"							  <li><a href=\"Search?key=Epistolary\">Epistolary novel</a></li>\r\n" + 
				"				        </ul>\r\n" + 
				"				        \r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"col_1_of_5 span_1_of_5\">\r\n" + 
				"					<h3 class=\"m_9\">Vehicles</h3>\r\n" + 
				"					<ul class=\"sub_list\">\r\n" + 
				"					    <li><a href=\"Search?key=Cycle\">Cycle</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=Bike\">Bike</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=Car\">Car</a></li>\r\n" + 
				"			  \r\n" + 
				"			         </ul>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"col_1_of_5 span_1_of_5\">\r\n" + 
				"					<h3 class=\"m_9\">Real Estates</h3>\r\n" + 
				"					<ul class=\"list1\">\r\n" + 
				"					     <li><a href=\"Search?key=1 BHK Flat\">1 BHK Flat</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=2 BHK Flat\">2 BHK Flat</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=3 BHK Flat\">3 BHK Flat</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=Single Room\">Single Room</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=Double Room \">Double Room</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=Family Room\">Family Room</a></li>\r\n" + 
				"			            <li><a href=\"Search?key=Campus\">Campus</a></li>\r\n" + 
				"		            </ul>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"col_1_of_5 span_1_of_5\">\r\n" + 
				"					<h3 class=\"m_9\">Dress</h3>\r\n" + 
				"					<ul class=\"list1\">\r\n" + 
				"					    \r\n" + 
				"					    <li><a href=\"Search?key=Swimwear\">Swimwear</a></li>\r\n" + 
				"					   \r\n" + 
				"					    <li><a href=\"Search?key=Fitness Equipment\">Fitness Equipment</a></li>\r\n" + 
				"					    <li><a href=\"Search?key=Partywears\">Partywears</a></li>\r\n" + 
				"					   <li><a href=\"Search?key=jewellery\">Jewellery</a></li>\r\n" + 
				"					    <li><a href=\"Search?key=Sports kits\">Sports Kits</a></li>\r\n" + 
				"		            </ul>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"col_1_of_5 span_1_of_5\">\r\n" + 
				"					<h3 class=\"m_9\">Support</h3>\r\n" + 
				"					<ul class=\"list1\">\r\n" + 
				"					   <li><a href=\"Index\">Customer Service</a></li>\r\n" + 
				"					   <li><a href=\"Index\">FAQ</a></li>\r\n" + 
				"					   <li><a href=\"Index\">Online Rental Showrooms Contact</a></li>\r\n" + 
				"					   <li><a href=\"Index\">about  Products</a></li>\r\n" + 
				"					   <li><a href=\"Index\">Ordering </a></li>\r\n" + 
				"					   <li><a href=\"Index\">Complains</a></li>\r\n" + 
				"					   <li><a href=\"Index\">Using out Site</a></li>\r\n" + 
				"					   <li><a href=\"sitemap.html\">Site Map</a></li>\r\n" + 
				"					   <li><a href=\"Index\">Gift Card</a></li>\r\n" + 
				"					  \r\n" + 
				"		            </ul>\r\n" + 
				"		            <ul class=\"sub_list2\">\r\n" + 
				"		               <h4 class=\"m_10\">Company Info</h4>\r\n" + 
				"			           <li><a href=\"shop.html\">About Us</a></li>\r\n" + 
				"			\r\n" + 
				"			        </ul>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"clear\"></div>\r\n" + 
				"			</div>\r\n" + 
				"       	 	</div>\r\n" + 
				"       	 </div>\r\n" + 
				"       	 <div class=\"copy\">\r\n" + 
				"       	   <div class=\"wrap\">\r\n" + 
				"       	   	  <p>© All rights reserved | Aavartan 2K17 &nbsp;<a href=\"http://nitrr.com/\"> NIT Raipur</a></p>\r\n" + 
				"       	   </div>\r\n" + 
				"       	 </div>\r\n" + 
				"       </div>\r\n" + 
				"       <script type=\"text/javascript\">\r\n" + 
				"			$(document).ready(function() {\r\n" + 
				"			\r\n" + 
				"				var defaults = {\r\n" + 
				"		  			containerID: 'toTop', // fading element id\r\n" + 
				"					containerHoverID: 'toTopHover', // fading element hover id\r\n" + 
				"					scrollSpeed: 1200,\r\n" + 
				"					easingType: 'linear' \r\n" + 
				"		 		};\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				$().UItoTop({ easingType: 'easeOutQuart' });\r\n" + 
				"				\r\n" + 
				"			});\r\n" + 
				"		</script>\r\n" + 
				"        <a href=\"#\" id=\"toTop\" style=\"display: block;\"><span id=\"toTopHover\" style=\"opacity: 1;\"></span></a>\r\n" + 
				"</body>\r\n" + 
				"</html> ");
	}
	public static void profileUpperView(PrintWriter out,User u)
	{
		
		out.print("<!DOCTYPE HTML>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Aavartan NIT Raipur</title>\r\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
				"<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n" + 
				"<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\r\n" + 
				"<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				"        $(document).ready(function() {\r\n" + 
				"            $(\".dropdown img.flag\").addClass(\"flagvisibility\");\r\n" + 
				"\r\n" + 
				"            $(\".dropdown dt a\").click(function() {\r\n" + 
				"                $(\".dropdown dd ul\").toggle();\r\n" + 
				"            });\r\n" + 
				"                        \r\n" + 
				"            $(\".dropdown dd ul li a\").click(function() {\r\n" + 
				"                var text = $(this).html();\r\n" + 
				"                $(\".dropdown dt a span\").html(text);\r\n" + 
				"                $(\".dropdown dd ul\").hide();\r\n" + 
				"                $(\"#result\").html(\"Selected value is: \" + getSelectedValue(\"sample\"));\r\n" + 
				"            });\r\n" + 
				"                        \r\n" + 
				"            function getSelectedValue(id) {\r\n" + 
				"                return $(\"#\" + id).find(\"dt a span.value\").html();\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            $(document).bind('click', function(e) {\r\n" + 
				"                var $clicked = $(e.target);\r\n" + 
				"                if (! $clicked.parents().hasClass(\"dropdown\"))\r\n" + 
				"                    $(\".dropdown dd ul\").hide();\r\n" + 
				"            });\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"            $(\"#flagSwitcher\").click(function() {\r\n" + 
				"                $(\".dropdown img.flag\").toggleClass(\"flagvisibility\");\r\n" + 
				"            });\r\n" + 
				"        });\r\n" + 
				"     </script>\r\n" + 
				"<!-- start menu -->     \r\n" + 
				"<link href=\"css/megamenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n" + 
				"<script type=\"text/javascript\" src=\"js/megamenu.js\"></script>\r\n" + 
				"<script>$(document).ready(function(){$(\".megamenu\").megamenu();});</script>\r\n" + 
				"<!-- end menu -->\r\n" + 
				"<!-- top scrolling -->\r\n" + 
				"<script type=\"text/javascript\" src=\"js/move-top.js\"></script>\r\n" + 
				"<script type=\"text/javascript\" src=\"js/easing.js\"></script>\r\n" + 
				"   <script type=\"text/javascript\">\r\n" + 
				"		jQuery(document).ready(function($) {\r\n" + 
				"			$(\".scroll\").click(function(event){		\r\n" + 
				"				event.preventDefault();\r\n" + 
				"				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);\r\n" + 
				"			});\r\n" + 
				"		});\r\n" + 
				"	</script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				" \r\n" + 
				" <div class=\"header-top\">\r\n" + 
				"	 <div class=\"wrap\"> \r\n" + 
				"		<div class=\"logo\">\r\n" + 
				"			<a href=\"Index\"><img src=\"images/rent.jpg\" alt=\"\"/>\r\n" + 
				"	    </div>\r\n" + 
				"	    <div class=\"cssmenu\">\r\n" + 
				"		   <ul>\r\n" + 
				"			\r\n" + 
				"			 <li><a href=\"Profile\">"+u.getName()+"</a></li> \r\n" + 
				"			<li><a href=\"Inbox\">message</a></li> \r\n" + 
				"			  <li><a href=\"Logout\">Logout</a></li> \r\n" + 
				"			\r\n" + 
				"			<style>\r\n" + 
				".menubtn {\r\n" + 
				"    background-color: darkblue;\r\n" + 
				"    color: white;\r\n" + 
				"    padding: 16px;\r\n" + 
				"    font-size: 16px;\r\n" + 
				"   \r\n" + 
				"}\r\n" + 
				".menudown {\r\n" + 
				"    position: relative;\r\n" + 
				"    display: inline-block;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				".menudown-content {\r\n" + 
				"    display: none;\r\n" + 
				"    position: absolute;\r\n" + 
				"    right: 0;\r\n" + 
				"    background-color: #f9f9f9;\r\n" + 
				"    min-width: 160px;\r\n" + 
				"    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\r\n" + 
				"    \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".menudown-content a {\r\n" + 
				"    color: black;\r\n" + 
				"    padding: 10px 8px;\r\n" + 
				"    text-decoration: none;\r\n" + 
				"    display: block;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				".menudown:hover .menudown-content {\r\n" + 
				"    display: block;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<div class=\"menudown\">\r\n" + 
				"    <a href=\"Cart\"><img src=\"images/logo.jpg\" height=50px width=50px alt=\"\"/>" + 
				"  <div class=\"menudown-content\" style=\"left:0;\">\r\n" + 
				"    <a href=\"Order?flag=2\"><b>Place Order</b></a>\r\n" +  
				"    <a href=\"\"><b></b></a>\r\n" + 
				"  </div>\r\n" + 
				"</div></body>\r\n"); 
		LinkedList<MyCart> cr=CartOperation.getCart(u.getId());
		if(cr!=null)
			out.println("<li>Added("+cr.size()+"</li>");
				out.println("</ul>\r\n" + 
				"		</div>\r\n" + 
				" \r\n" + 
				"		<ul class=\"icon2 sub-icon2 profile_img\">\r\n" + 
				"			<li><a class=\"active-icon c2\" href=\"Index\"> </a>\r\n" + 
				"				<ul class=\"sub-icon2 list\">\r\n" + 
				"					<li><h3>My Cart</h3><a href=\"Index\"></a></li><li><p><li>\r\n");
				if(cr!=null)
					for(MyCart c:cr) {
						out.print("<li><p><li>"+Dbitemopr.getItem(c.getitemid()).getName()+"</l1> <br/> <a href=\"ChartSer?flag=2&itemid="+c.getitemid()+"\"><font color=\"red\">Remove</font></a></p></li>");
					}
				else
					out.print("No product In your Cart</li></p></li>");
				//out.print("<a href=\"ChartSer?flag=3>Clear My Cart</a>");
				out.print("</ul></li>\r\n" + 
				"		</ul>\r\n" + 
				"		<div class=\"clear\"></div>\r\n" + 
				" 	</div>\r\n" + 
				"   </div>\r\n" +   
				"   <div class=\"header-bottom\">\r\n" + 
				"   	<div class=\"wrap\">\r\n" + 
				"   		<!-- start header menu -->\r\n" + 
				"		<ul class=\"megamenu skyblue\">\r\n" + 
				"		    <li><a class=\"color1\" href=\"Index\">Home</a></li>\r\n" + 
				"			<li class=\"grid\"><a class=\"color2\" href=\"#\">Books</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Engneering</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=mechanical\">Machanical</a></li>\r\n" + 
				"									<li><a href=\"Search?key=civil\">Civil</a></li>\r\n" + 
				"									<li><a href=\"Search?key=chemical\">Chemical</a></li>\r\n" + 
				"									<li><a href=\"Search?key=electronix\">Electronix</a></li>\r\n" + 
				"									<li><a href=\"Search?key=computer science\">Computer Science</a></li>\r\n" + 
				"	\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4 class=\"top\">Medical</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=mbbs\">MBBS</a></li>\r\n" + 
				"									<li><a href=\"Search?key=bds\">BDS</a></li>\r\n" + 
				"									<li><a href=\"Search?key=b pharma\">B Pharma</a></li>\r\n" + 
				"									<li><a href=\"Search?key=m pharma\">M Pharma</a></li>\r\n" + 
				"								\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Management</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=human resource\">Human Resource</a></li>\r\n" + 
				"									<li><a href=\"Search?key=facility management\">Facility Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=operation management\">Operation Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=system management\">System Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=financial management\">Financial Management</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Novels</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=human resource\">Human Resource</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Facility Management\">Facility Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Operation Management\">Operation Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=System Management\">System Management</a></li>\r\n" + 
				"									<li><a href=\"Search?key=System Management\">Financial Management</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<img src=\"images/books.jpg\" height=\"200px\" widthalt=\"\"/>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				</li>\r\n" + 
				"  			   <li class=\"active grid\"><a class=\"color4\" href=\"#\">Vehicles</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Cycle</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Mountain Cycle\">Mountain Cycle</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Racing Cycle\">Racing Cycle</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Two Wheeler</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Scooty\">Scooty</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Bike\">Bike</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"							<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Four Wheeler</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Car\">Car</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Transport Vehicles\">Transport Vehicles</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"						 <div class=\"h_nav\">\r\n" + 
				"						   <img src=\"images/cycle.png\" alt=\"\"/>\r\n" + 
				"						 </div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"					</div>\r\n" + 
				"					</div>\r\n" + 
				"    			</li>				\r\n" + 
				"				<li><a class=\"color5\" href=\"Search?key=Real estate\">Real Estates</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Flats</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=1 bhk flat\">1 BHK Flat</a></li>\r\n" + 
				"									<li><a href=\"Search?key=2 bhk flat\">2 BHK Flat</a></li>\r\n" + 
				"									<li><a href=\"Search?key=3 bhk flat\">3 BHK Flat</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4 class=\"top\">Rooms</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=single room\">Single Room</a></li>\r\n" + 
				"									<li><a href=\"Search?key=double room\">Double Room</a></li>\r\n" + 
				"									<li><a href=\"Search?key=family room\">Family  Room</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<img src=\"images/house.jpg\" alt=\"\"/>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				</li>\r\n" + 
				"				<li><a class=\"color7\" href=\"#\">Party Wears</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Man</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=kurta pyjama\">Kurta Pyjama</a></li>\r\n" + 
				"									<li><a href=\"Search?key=sherwani\">Sherwani</a></li>\r\n" + 
				"									<li><a href=\"Search?key=mens grooming\">Mens Grooming</a></li>\r\n" + 
				"									<li><a href=\"Search?key=party suits\">Party suits</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Woman</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=ethnic wear\">Ethnic Wear</a></li>\r\n" + 
				"									<li><a href=\"Search?key=beauty grooming\">Beauty & Grooming</a></li>\r\n" + 
				"									<li><a href=\"Search?key=jewellery\">Jewellery</a></li>\r\n" + 
				"									<li><a href=\"Search?key=International Brand\">International Brand</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Accessories\">Accessories</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"					\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<img src=\"images/dress.jpg\" alt=\"\"/>\r\n" + 
				"					</div>\r\n" + 
				"    				</div>\r\n" + 
				"				</li>\r\n" + 
				"				\r\n" + 
				"				<li><a class=\"color7\" href=\"#\">Electronics</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Fan</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Stand Fan\">Stand Fan</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Table Fan\">Table Fan</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Fan in Bulk\">Fan in Bulks for Function</a></li>\r\n" + 
				"									<li><a href=\"Search?key=coolers\">Coolers</a></li>\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4> Hardware</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Printer\">Printer</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Scanner\">Scanner</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Ploatter\">Ploatter</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Computer Hardware\">Others</a></li>\r\n" + 
				"								\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"							<div class=\"col1\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h4>Others</h4>\r\n" + 
				"								<ul>\r\n" + 
				"									<li><a href=\"Search?key=Camera\">Digital Cameras</a></li>\r\n" + 
				"									<li><a href=\"Search?key=Electronic Function\">Electronic Product for Function</a></li>\r\n" + 
				"								\r\n" + 
				"								</ul>	\r\n" + 
				"							</div>							\r\n" + 
				"						</div>\r\n" + 
				"					\r\n" + 
				"					<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<img src=\"images/dress.jpg\" alt=\"\"/>\r\n" + 
				"					</div>\r\n" + 
				"    				</div>\r\n" + 
				"				</li>\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				\r\n" + 
				"				<li><a class=\"color6\" href=\"aboutus.html\">About Us</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"					\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"									\r\n" + 
				"											\r\n" + 
				"						<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				</li>\r\n" + 
				"				<li><a class=\"color8\" href=\"#\">Contact Us</a>\r\n" + 
				"				<div class=\"megapanel\">\r\n" + 
				"							<div class=\"h_nav\">\r\n" + 
				"								<h2>For any technical queries, Contact Helpdesk No's: +91-8407095037, \r\n" + 
				"								+91-9634064603, +91-7352286834 (from 10:30AM to 5:00PM Monday to Saturday working days only) \r\n" + 
				"								E-mail: afsaredrisy@gmail.com,basantkumar562@gmail.com</h3>\r\n" + 
				"								</div>							\r\n" + 
				"						</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				</li>\r\n" + 
				"						<div class=\"row\">\r\n" + 
				"						<div class=\"col2\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"						<div class=\"col1\"></div>\r\n" + 
				"					</div>\r\n" + 
				"    				</div>\r\n" + 
				"				</li>\r\n" + 
				"				\r\n" + 
				"		   </ul>\r\n" + 
				"		   <div class=\"clear\"></div>\r\n" + 
				"     	</div>\r\n" + 
				"       </div>");
	}
	public static void showResult(PrintWriter out,LinkedList<Item> list,int index)
	{
			for(Item i:list)
			{
				out.print(" 		  <div class=\"clear\"></div>			\r\n" + 
						"				   </div>\r\n" + 
						"				  <div class=\"content-bottom\">\r\n" + 
						"				   <div class=\"box1\">\r\n" + 
						"				    <div class=\"col_1_of_3 span_1_of_3\"><a href=\"ItemView?itemid="+i.getitemid()+"\">\r\n" + 
						"				     <div class=\"view view-fifth\">\r\n" + 
						"				  	  <div class=\"top_box\">\r\n" + 
						"					  	<h3 class=\"m_1\">"+i.getName()+"</h3>\r\n" + 
						"					  	<p class=\"m_2\">Item</p>\r\n" + 
						"				         <div class=\"grid_img\">\r\n" + 
						"						   <div class=\"css3\"><img width='250' height='250' src=DisplayImage?userid="+i.getitemid()+"&flag=2></img></div>\r\n" + 
						"					          <div class=\"mask\">\r\n" + 
						"	                       		<div class=\"info\">Quick View</div>\r\n" + 
						"			                  </div>\r\n" + 
						"	                    </div>\r\n" + 
						"                       <div class=\"price\">Rs"+i.getrent()+"<font color=white>............................... </font>"
								+ "<font color=red><a href=\"ChartSer?flag=1&itemid="+i.getitemid()+"\">Add to Cart</a></font></div>\r\n" + 
						"					   </div>\r\n" + 
						"					    </div>\r\n" + 
						"					   <span class=\"rating\">\r\n" + 
						"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-5\" name=\"rating-input-1\">\r\n" + 
						"				        <label for=\"rating-input-1-5\" class=\"rating-star1\"></label>\r\n" + 
						"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-4\" name=\"rating-input-1\">\r\n" + 
						"				        <label for=\"rating-input-1-4\" class=\"rating-star1\"></label>\r\n" + 
						"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-3\" name=\"rating-input-1\">\r\n" + 
						"				        <label for=\"rating-input-1-3\" class=\"rating-star1\"></label>\r\n" + 
						"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-2\" name=\"rating-input-1\">\r\n" + 
						"				        <label for=\"rating-input-1-2\" class=\"rating-star\"></label>\r\n" + 
						"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-1\" name=\"rating-input-1\">\r\n" + 
						"				        <label for=\"rating-input-1-1\" class=\"rating-star\"></label>&nbsp;\r\n" + 
						"		        	  (45)\r\n" + 
						"		    	      </span>\r\n" + 
						"						 <ul class=\"list\">\r\n" + 
						"						  <li>\r\n" + 
						"						  	<img src=\"images/plus.png\" alt=\"\"/>\r\n" + 
						"						  	<ul class=\"icon1 sub-icon1 profile_img\">\r\n" + 
						"							  <li><a class=\"active-icon c1\" href=\"Order?itemid="+i.getitemid()+"\">Order Now </a>\r\n" + 
						"								<ul class=\"sub-icon1 list\">\r\n" + 
						"									<li><h3>sAt "+i.getName()+"</h3><a href=\"\"></a></li>\r\n" + 
						"									<li><p> "+i.getdescription()+" at "+i.getcity()+"<a href=ItemView?itemid="+i.getitemid()+">View</a></p></li>\r\n" + 
						"								</ul>\r\n" + 
						"							  </li>\r\n" + 
						"							 </ul>\r\n" + 
						"						   </li>\r\n" + 
						"					     </ul>");
		}
			out.println(" 	  <div class=\"clear\"></div>\r\n" + 
					"			    	</a></div>\r\n" + 
					"				  <div class=\"clear\"></div>\r\n" + 
					"			    </div>\r\n" + 
					"			  </div>\r\n" + 
					"			 </div>\r\n" + 
					"        </div>");
}
	
}