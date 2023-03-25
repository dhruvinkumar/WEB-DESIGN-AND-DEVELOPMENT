$(document).ready(function() {
$.ajax({
url: "data.json",
dataType: "json",
success: function(data) {
var html = "<p>Name: " + data.name + "</p>";
html += "<p>Model: " + data.model + "</p>";
html += "<p>Price: " + data.price + "</p>";
$("#data").html(html);
}
});
});