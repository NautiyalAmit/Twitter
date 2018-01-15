function reload() {
		location.reload();
	}
	function LimtCharacters(txtMsg, CharLength, indicator) {
		chars = txtMsg.value.length;
		document.getElementById(indicator).innerHTML = CharLength - chars;
		if (chars > CharLength) {
			alert("Cannot insert more than 140 characters");
			txtMsg.value = txtMsg.value.substring(0, CharLength);
		}
	}