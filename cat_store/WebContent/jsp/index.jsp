<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>三只馋猫零食商城</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
$(function(){
	$.post("${ pageContext.request.contextPath }/CategoryServlet",{"method":"findAll"},function(data){
		alert(data);
	});
});
</script> -->
</head>
<body>
	<div class="container-fluid">
<%@ include file="menu.jsp" %>
		<%--描述：轮播条 --%>
		<div class="container-fluid">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<%-- Wrapper for slides --%>
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${ pageContext.request.contextPath }/img/1.jpg">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${ pageContext.request.contextPath }/img/2.jpg">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${ pageContext.request.contextPath }/img/3.jpg">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="${ pageContext.request.contextPath }/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="${ pageContext.request.contextPath }/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				<c:forEach var="p" items="${ hotList }">
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="${ pageContext.request.contextPath }/ProductServlet?method=findByPid&pid=${ p.pid}">
							<img src="${ pageContext.request.contextPath }/${ p.pimage}" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="${ pageContext.request.contextPath }/ProductServlet?method=findByPid&pid=${ p.pid}" style='color:#666'>${ p.pname }</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;${ p.shop_price }</font></p>
					</div>
					</c:forEach>
				
					
				<%-- 
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small03.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.htm" style='color:#666'>艾园海带结泡椒味</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;8.80</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small04.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>阿尔善风干牛肉香辣味</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;49.50</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small05.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>百年树桂圆</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;39.00</font></p>
					</div>
					
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small06.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>GEMEZ Enaak 小鸡干</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;1.60</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small07.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>百年树爽脆黄秋葵淡盐</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;39.90</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small08.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>百年树芒果干*500g</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;46.00</font></p>
					</div>
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small09.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>芭米手工牛轧饼海苔味</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;8.50</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small10.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>拾光悠味网红辣丝</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;8.80</font></p>
					</div>

					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small11.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>加煌爽口麻辣味笋尖</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;4.50</font></p>
					</div> --%>
				</div>
			</div>
            <div class="container-fluid">
				<img src="${ pageContext.request.contextPath }/products/hao/ad.jpg" width="100%"/>
			</div>
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>优惠促销&nbsp;&nbsp;<img src="${ pageContext.request.contextPath }/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="${ pageContext.request.contextPath }/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/middle02.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>力诚香辣味仿蟹柳</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;18.50</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small2.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>阿伯仔脆鸭肠脆卤香辣味</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;22.50</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small3.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>盛歌焙怡牛奶味涂层饼干条</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;8.00</font></p>
					</div>
					
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small4.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>宏香记香菇牛肉豆脯</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;15.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small5.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>妙纪菠萝蜜干</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;19.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small6.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>顽皮兔妙乐滋优酪果冻黄桃味</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;10.80</font></p>
					</div>
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small7.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>水军比心肉松糯米饭锅巴</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;9.80</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small8.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>芳草草塔味葵瓜子 </a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;5.50</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="${ pageContext.request.contextPath }/products/hao/small9.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>骥洋卤香鹌鹑蛋</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;11.00</font></p>
					</div>
				</div>
			</div>		
			
				
			<div class="container-fluid">
				<div style="margin-top:50px;">
					<img src="${ pageContext.request.contextPath }/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
				</div>
		
				<div style="text-align: center;margin-top: 5px;">
					<ul class="list-inline">
						<li><a href="info.html">关于我们</a></li>
						<li><a>联系我们</a></li>
						<li><a>招贤纳士</a></li>
						<li><a>法律声明</a></li>
						<li><a>友情链接</a></li>
						<li><a>支付方式</a></li>
						<li><a>配送方式</a></li>
						<li><a>服务声明</a></li>
						<li><a>广告声明</a></li>
					</ul>
				</div>
				<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
					Copyright &copy; 2011-2019 馋猫商城 版权所有
				</div>
			</div>
		</div>
	</body>

</html>