function lookup(inputString) {
		if (inputString.length == 0) {
			$('#suggestions').hide();
		} else {
			$.post("SearchServlet", {
				queryString : "" + inputString + ""
			}, function(data) {
				if (data.length > 0) {
					$('#suggestions').show();
					$('#autoSuggestionsList').html(data);
				}
				$("#autoSuggestionsList ul li").click(function() {

					var value = $(this).html();
					$('#suggestions').hide();

				});

			});
		}
	}

$(function() {
	 $('a[href*=#]:not([href=#])').click(function() {
	   if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
	     var target = $(this.hash);
	     target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
	     if (target.length) {
	       $('html,body').animate({
	         scrollTop: target.offset().top
	       }, 900);
	       return false;
	     }
	   }
	 });
	});
function LimtCharacters(txtMsg, CharLength, indicator) {
	chars = txtMsg.value.length;
	document.getElementById(indicator).innerHTML = CharLength - chars;
	if (chars > CharLength) {
		document.getElementById(indicator).innerHTML = 0;
		alert("ONLY 140 CHARACTERS ALLOWED");
	txtMsg.value = txtMsg.value.substring(0, CharLength);
	}
	}