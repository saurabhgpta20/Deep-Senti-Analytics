<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags"%>
   <link rel="stylesheet" type="text/css" href="styles.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<style>
body{
	float:right;
	margin-left: 900px;
	margin-top: 200px;
	position: absolute;
	
}


ul {
    margin: 20px;
}

.input-color {
    position: relative;
}
.input-color input {
    padding-left: 20px;
}
.input-color .color-box {
    width: 10px;
    height: 10px;
    display: inline-block;
    background-color: #ccc;
    position: absolute;
    left: 7px;
    top: 5px;
}
.orientation{
	position: absolute;
}
</style>
<body>
<s:hidden id = "inputtweet" name = "inputtweet"/>
<s:hidden id = "positive" name = "positive"/>
<s:hidden id = "negative" name = "negative"/>
<s:hidden id = "neutral" name = "neutral"/>
<s:hidden id = "tweetsentiment" name = "tweetsentiment"/>
<div style="margin-top: -150px; margin-left: -800px; position: absolute;">
<img src="images/adapt_logo.png" width="200" height="130" alt=""
			class="left" align="middle" style="vertical-align: middle; margin-top: -20px; margin-left: -20px;" />
			<p style="text-align: center; margin-top: -85px; margin-left:400px; font-family: 'Gill Sans', 'Gill Sans MT', 'Myriad Pro', 'DejaVu Sans Condensed', Helvetica, Arial, sans-serif; font-size: 50px;">Deep Senti-Analytics</p>
			<hr width="140%"/>
	<h3><label for = "title" >Entered Keyword: </label><br></br>
	<textarea id="title" name="title"  rows="4" cols="50" readonly="readonly" style="resize:none;"><s:property value="inputtweet" /></textarea></h3>
	<h3>Sentiment of your tweet: <s:property value="tweetsentiment"/></h3>
	
	<h3><u>Top Positive Tweets</u></h3>
	<s:subset start="0" count="10" source="top10posTweets">
	<table border="1" width="350">
	<s:iterator>
		
		<tr>
			<td>
				<s:property /></br>
			</td>
		</tr>
		
	</s:iterator>
	</table>
</s:subset>
</div>
<div style="margin-top: 135px; margin-left: -400px; position: absolute;">
</br>
	<h3><u>Top Negative Tweets</u></h3>
	<s:subset start="0" count="10" source="top10negTweets">
	<table border="1" width="350">
	<s:iterator>
		
		<tr>
			<td>
				<s:property /></br>
			</td>
		</tr>
		
	</s:iterator>
	</table>
</s:subset>
</div>

<div style="margin-top: 650px; margin-left: 00px; position: absolute;">
</br>
<s:form action="sentimentanalysis1.action" method="post">
	<s:hidden name = "inputtweet1" value="%{inputtweet}"/>
	<s:submit cssClass="button" method="sentimentAnalysis1" key="label.sentimentirish" align="center" />
</s:form>
</div>
<h3>Overall Sentiment of #GE16</h3>
<script src="https://d3js.org/d3.v3.min.js"></script>
<script>
var v1 = document.getElementById("positive").value;
var v2 = document.getElementById("negative").value;
var v3 = document.getElementById("neutral").value;
// Define the data as a two-dimensional array of numbers. If you had other
// data to associate with each number, replace each number with an object, e.g.,
// `{key: "value"}`.
var data = [
    [v1,v2,v3]
];

// Define the margin, radius, and color scale. The color scale will be
// assigned by index, but if you define your data using objects, you could pass
// in a named field from the data object instead, such as `d.name`. Colors
// are assigned lazily, so if you want deterministic behavior, define a domain
// for the color scale.
var m = 10,
    r = 100,
    z = d3.scale.category20c();
	var color = d3.scale.ordinal()
    .range(["#6baed6", "#fdae6b", "#a1d99b"]);
var labelArc = d3.svg.arc()
    .outerRadius(r - 40)
    .innerRadius(r - 40);

// Insert an svg element (with margin) for each row in our dataset. A child g
// element translates the origin to the pie center.
var svg = d3.select("body").selectAll("svg")
    .data(data)
  .enter().append("svg")
    .attr("width", (r + m) * 2)
    .attr("height", (r + m) * 2)
  .append("g")
    .attr("transform", "translate(" + (r + m) + "," + (r + m) + ")");

// The data for each svg element is a row of numbers (an array). We pass that to
// d3.layout.pie to compute the angles for each arc. These start and end angles
// are passed to d3.svg.arc to draw arcs! Note that the arc radius is specified
// on the arc, not the layout.
svg.selectAll("path")
    .data(d3.layout.pie())
  .enter().append("path")
    .attr("d", d3.svg.arc()
        .innerRadius(0)
        .outerRadius(r))
    .style("fill", function(d, i) { return color(i); });
	
 svg.append("text")
      .attr("dy", ".2em")
	  .attr("dx", "2.5em")
      .text(function(d) { return d[0] + "%";});

svg.append("text")
      .attr("dy", "2.5em")
	  .attr("dx", "-3.3em")
      .text(function(d) { return d[1] + "%";});
	  
svg.append("text")
      .attr("dy", "-2.6em")
	  .attr("dx", "-3.0em")
      .text(function(d) { return d[2] + "%";});
</script>



    
        <div class="input-color" style="margin-left:25px;">
            <input type="text" value="Positive" />
            <div class="color-box" style="background-color: #6baed6;"></div>
            <!-- Replace "#FF850A" to change the color -->
        </div>
    
    
        <div class="input-color" style="margin-left:25px;">
            <input type="text" value="Negative" />
            <div class="color-box" style="background-color: #fdae6b;"></div>
            <!-- Replace "navy" to change the color -->
        </div>
		
		<div class="input-color"style="margin-left:25px;">
            <input type="text" value="Neutral" />
            <div class="color-box" style="background-color: #a1d99b;"></div>
            <!-- Replace "#FF850A" to change the color -->
        </div>
    


</body>