function validate(form) {
		var msg = form.EditTweetArea.value;

		if (msg.length === 0) {
			alert("You must enter something");
			return false;
		}
				return true;
	}