/**
 * Sign up form Validation
 */
function formValidator() {
	var username = document.getElementById('usercheck');
	var ans = document.getElementById('anscheck');
	var email = document.getElementById('emailcheck');

	// Checking each input in the order that it appears in the form!
	if (isUsername(username,
			"Please enter AlphaNumeric characters between 4 and 8 for UserName.")) {
		if (isAnsNotEntered(ans, "Please re-enter same password.")) {
			if (isEmail(email, "Please enter a valid email address.")) {
				return true;
			}
		}
	}

	return false;
}

function isUsername(elem, helperMsg) {
	var alphaExp = /^[0-9a-zA-Z]+$/;
	if (elem.value.match(alphaExp)
			&& (elem.value.length >= 4 && elem.value.length <= 8)) {
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