/**
 * 
	Find whether username and password is empty or not
 */
function validate(form) {
	var username = form.name.value;
	var password = form.password.value;
	if (username.length === 0) {
		alert("Enter username!");
		return false;
	}
	if (password.length === 0) {
		alert("Enter password!");
		return false;
	}
	return true;
}
function tweet(form) {
	var a = form.modifytweet.value;
	
	if (a.length === 0) {
		alert("Enter !");
		return false;
	}
	return true;
}