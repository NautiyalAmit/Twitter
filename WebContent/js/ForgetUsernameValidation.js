/**
 * Forget username Validation
 */
function formValidator() {
	var fullname = document.getElementById('fullcheck');
	var ans = document.getElementById('anscheck');
	var email = document.getElementById('emailcheck');

	// Checking each input in the order that it appears in the form!

	if (isFullname(fullname,
			"Please enter letters for your FullName.")) {
		if (isAnsNotEntered(ans, "Please re-enter same password.")) {
			if (isEmail(email, "Please enter a valid email address.")) {
				return true;
			}
		}
	}
	return false;
}

function isFullname(elem, helperMsg) {
	var alphaExp = /^[a-zA-Z\s]+$/;
	if (elem.value.match(alphaExp)) {
		return true;
	} else {
		alert(helperMsg);
		elem.focus();
		return false;
	}
}

function isAnsNotEntered(elem, helperMsg) {
	if (elem.value.length === 0) {
		alert(helperMsg);
		elem.focus();
		return false;
	} else {
		return true;
	}
}

function isEmail(elem, helperMsg) {
	var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	if (elem.value.match(emailExp)) {
		return true;
	} else {
		alert(helperMsg);
		elem.focus();
		return false;
	}
}