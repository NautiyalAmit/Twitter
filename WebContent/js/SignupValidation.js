function formValidator() {
		// Make quick references to our fields
		var username = document.getElementById('username');
		var fullname = document.getElementById('fullname');
		var password = document.getElementById('password');
		var confirm_password = document.getElementById('confirm_password');
		var ans = document.getElementById('anscheck');
		var email = document.getElementById('email');
		var i_agree = document.getElementById('i_agree');

		// Check each input in the order that it appears in the form!
		if (isUsername(username,
				"Please enter AlphaNumeric characters between 4 and 8 for UserName.")) {
			if (isFullname(fullname,
					"Please enter letters for your FullName.")) {
				if (isPassword(password,
						"Please enter a valid password(Alphanumeric characters between 4 and 8.)")) {
					if (isPasswordNotEntered(confirm_password,
							"Please re-enter same password.")) {
						if (isConfirmPassword(confirm_password, password,
								"Password not matching.Retype same password.")) {
							if (isAnsNotEntered(ans,
									"Please ans the security question.")) {
								if (isEmail(email,
										"Please enter a valid email address.")) {
									if (isAgree(i_agree,
											"You must agree to the terms.")) {
										return true;
									}
								}
							}
						}
					}
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

	function isAgree(elem, helperMsg) {
		if (elem.checked) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	