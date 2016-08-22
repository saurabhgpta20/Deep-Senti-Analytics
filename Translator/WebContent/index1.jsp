<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags"%>
   <link rel="stylesheet" type="text/css" href="styles.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Welcome</title>
</head>
<style>

.arc text {
  font: 10px sans-serif;
  text-anchor: middle;
}

.arc path {
  stroke: #fff;
}

</style>
<body>
<s:hidden id = "inputtweet" name = "inputtweet"/>
<s:hidden id = "positive" name = "positive"/>
<s:hidden id = "negative" name = "negative"/>
<s:hidden id = "neutral" name = "neutral"/>
<s:hidden id = "tweetsentiment" name = "tweetsentiment"/>
<h3><label for = "title">Entered Tweet: </label><br></br><textarea id="title" name="title"  rows="4" cols="50" readonly="readonly" style="resize:none"><s:property value="inputtweet" /></textarea></h3>
<h3>Sentiment of your tweet: <s:property value="tweetsentiment"/></h3>



<script src="https://d3js.org/d3.v3.min.js"></script>
<script>

var width = 1900,
    height = 400,
    radius = Math.min(width, height) / 2;


var data = [{"sentiment": "Positive", "percentage": positive},
			{"sentiment": "Negative", "percentage": negative},
			{"sentiment": "Neutral", "percentage": neutral}];

var arc = d3.svg.arc()
    .outerRadius(radius - 10)
    .innerRadius(0);

var color = d3.scale.ordinal()
    .range(["#98abc5", "#6b486b", "#a05d56"]);
	
var labelArc = d3.svg.arc()
    .outerRadius(radius - 40)
    .innerRadius(radius - 40);

var pie = d3.layout.pie()
    .sort(null)
    .value(function(d) { return d.percentage; });

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height + 200)
  .append("g")
    .attr("transform", "translate(" + width / 2 + "," + height /1.3 + ")");



  var g = svg.selectAll(".arc")
      .data(pie(data))
    .enter().append("g")
      .attr("class", "arc");

  g.append("path")
      .attr("d", arc)
      .style("fill", function(d) { return color(d.data.sentiment); });

  g.append("text")
      .attr("transform", function(d) { return "translate(" + labelArc.centroid(d) + ")"; })
      .attr("dy", "1.3em")
      .text(function(d) { return d.data.sentiment; });


function type(d) {
  d.percentage = +d.percentage;
  return d;
}

</script>
</body>