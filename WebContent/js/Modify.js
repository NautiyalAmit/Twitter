function isValid() {
		var alphaExp = /^[0-9a-zA-Z]+$/;
		var password = document.getElementById('password1');
		var confirm_password = document.getElementById('c_password1');

		if (isPassword(password,
				"Please enter a valid password(Alphanumeric characters between 4 and 8.)")) {
			if (isPasswordNotEntered(confirm_password,
					"Please re-enter same password.")) {
				if (isConfirmPassword(confirm_password, password,
						"Password not matching.Retype same password.")) {
					return true;
				}
			}
		}
		return false;
	}
	function isPassword(elem, helperMsg) {
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

	function isPasswordNotEntered(elem, helperMsg) {
		if (elem.value.length === 0) {
			alert(helperMsg);
			elem.focus();
			return false;
		} else {
			return true;
		}
	}
	function isConfirmPassword(elem, elem1, helperMsg) {
		if (elem.value === elem1.value) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function isFullname() {
		var elem = document.getElementById('fullname1');
		var helperMsg = "Please enter letters for your FullName.";
		var alphaExp = /^[a-zA-Z\s]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}

	function isPassword() {
		var alphaExp = /^[0-9a-zA-Z]+$/;
		var elem = document.getElementById('password1');
		var helperMsg = "Please enter a valid password(Alphanumeric characters between 4 and 8.)";
		if (elem.value.match(alphaExp)
				&& (elem.value.length >= 4 && elem.value.length <= 8)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}

	function isEmail() {
		var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		var elem = document.getElementById('email1');
		var helperMsg = "Please enter a valid email address";
		if (elem.value.match(emailExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}