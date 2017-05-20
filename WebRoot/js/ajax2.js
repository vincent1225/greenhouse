function ajax2(url, params, callback,onerror) {
	var obAjax = new Object();
	obAjax.req = null;

	obAjax.defaultError = function() {
		alert("系统忙，请您稍候再试!");
	};

	obAjax.onerror = (onerror) ? onerror : obAjax.defaultError;

	if (window.XMLHttpRequest)
		obAjax.req = new XMLHttpRequest();
	else if (window.ActiveXObject)
		obAjax.req = new ActiveXObject("Microsoft.XMLHTTP");

	if (obAjax.req) {
		obAjax.req.onreadystatechange = function() {
			if (obAjax.req.readyState == 4) {
				if (obAjax.req.status == 200 || obAjax.req.status == 0){
					callback.call(obAjax);
				}
				else
					obAjax.onerror.call(obAjax);
			}
		};

		obAjax.req.open("POST", url, true);
		if (contentType)
			obAjax.req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

		obAjax.req.send(params);
	} else {
		obAjax.onerror.call(obAjax);
	}
}















/*function executeAjax2(callback, url, params, method, onerror, contentType) {
	var obAjax = new Object();
	obAjax.req = null;
	obAjax.method = !method ? "GET" : "POST";
	if (!contentType && method == "POST")
		contentType = 'application/x-www-form-urlencoded';

	obAjax.defaultError = function() {
		alert("系统忙，请您稍候再试!");
	}

	obAjax.onerror = (onerror) ? onerror : obAjax.defaultError;

	if (window.XMLHttpRequest)
		obAjax.req = new XMLHttpRequest();
	else if (window.ActiveXObject)
		obAjax.req = new ActiveXObject("Microsoft.XMLHTTP");

	if (obAjax.req) {
		obAjax.req.onreadystatechange = function() {
			if (obAjax.req.readyState == 4) {
				if (obAjax.req.status == 200 || obAjax.req.status == 0){
					callback.call(obAjax);
				}
				else
					obAjax.onerror.call(obAjax);
			}
		}

		obAjax.req.open(obAjax.method, url, true);
		if (contentType)
			obAjax.req.setRequestHeader('Content-Type', contentType);

		obAjax.req.send(params);
	} else {
		obAjax.onerror.call(obAjax);
	}
}*/