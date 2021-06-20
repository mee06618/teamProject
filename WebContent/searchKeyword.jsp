<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>


<script>

$(function() {

    var availableTags = ["서울","부산","대구","광주","울산"];

    $("#autocomplete").autocomplete({

        source: availableTags,

        select: function(event, ui) {

            console.log(ui.item);

        },

        focus: function(event, ui) {

            return false;

            

        }

    });

});




  </script>




<body>

   			<form action=""method="POST" onsubmit="return false">
            	<input id="autocomplete" type="text" />
            	<input type="submit" value="변환"/>
            </form>
</body>
</html>