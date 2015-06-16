$(document).ready(

	// "users/{username}"
	function() {
		var $mainurl = "http://localhost:8080/api/v0/";


		$('#serviceLocation').val($mainurl + "users/{username}"); // se modifica el valor del url
		$('#serviceDescription').val("     Recibe un nombre de usuario y devuelve un JSON con sus datos principales."); // descripcion del servicio
		$('#serviceName').val("Obtener Usuario"); // nombre del servicio
		$("#wizard").attr("onclick","vacio()");


		$('#getUser,#getUsuario').on('click', function() { 
			$('#serviceLocation').val($mainurl + "users/{username}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y devuelve un JSON con sus datos principales."); // descripcion del servicio
			$('#serviceName').val("Obtener Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#getFollowers,#getSeguidores').on('click', function() { 
			$('#serviceLocation').val($mainurl + "users/{username}/followers"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y devuelve un JSON con todos sus seguidores."); // descripcion del servicio
			$('#serviceName').val("Obtener Quienes Siguen al Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#getFollowing,#getSeguidos').on('click', function() { 
			$('#serviceLocation').val($mainurl + "users/{username}/followed"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y devuelve un JSON con todos los usuarios seguidos por dicho usuario."); // descripcion del servicio
			$('#serviceName').val("Obtener a Quienes el Usuario Sigue"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#getPosts,#getPublicaciones').on('click', function() { 
			$('#serviceLocation').val($mainurl + "posts/{username}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y devuelve un JSON con todas sus publicaciones."); // descripcion del servicio
			$('#serviceName').val("Obtener Publicaciones de Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#getNotifications,#getNotificaciones').on('click', function() { 
			$('#serviceLocation').val($mainurl + "notifications/{username}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y devuelve un JSON con todas sus notificaciones."); // descripcion del servicio
			$('#serviceName').val("Obtener Notificaciones de Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#getMedals,#getMedallas').on('click', function() { 
			$('#serviceLocation').val($mainurl + "medals/{username}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y devuelve un JSON con todas sus medallas."); // descripcion del servicio
			$('#serviceName').val("Obtener Medallas de Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#getWall,#getMuro').on('click', function() { 
			$('#serviceLocation').val($mainurl + "posts/feed/{username}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y devuelve un JSON con todas las publicaciones del muro de dicho usuario."); // descripcion del servicio
			$('#serviceName').val("Obtener Muro de Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#searchPosts,#searchPublicaciones').on('click', function() { 
			$('#serviceLocation').val($mainurl + "posts"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un JSON con un rango de fechas y una región, y devuelve todos las publicaciones que cumplan esas características."); // descripcion del servicio
			$('#serviceName').val("Buscar Publicaciones"); // nombre del servicio
			$("#wizard").attr("onclick","searchPosts()");
		});
		
		$('#postUser,#postUsuario').on('click', function() { 
			$('#serviceLocation').val($mainurl + "users"); // se modifica el valor del url
			$('#serviceDescription').val("     Agrega un usuario en la red social."); // descripcion del servicio
			$('#serviceName').val("Agregar Usuario"); // nombre del servicio
			//$('#wizard').click(function(){ addUser(); });
			$("#wizard").attr("onclick","addUser()");
		});
		
		$('#postPost,#postPublicacion').on('click', function() { 
			$('#serviceLocation').val($mainurl + "posts"); // se modifica el valor del url
			$('#serviceDescription').val("     Agrega una publicación a la red social."); // descripcion del servicio
			$('#serviceName').val("Agregar Publicación"); // nombre del servicio
			//$('#wizard').click(function(){ addPost(); });
			$("#wizard").attr("onclick","addPost()");
		});
		
		$('#postComment,#postComentario').on('click', function() { 
			$('#serviceLocation').val($mainurl + "posts/{id}/comments"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un id de una publicación y agrega un comentario a dicha publicación."); // descripcion del servicio
			$('#serviceName').val("Agregar Comentario"); // nombre del servicio
			//$('#wizard').click(function(){ addComment(); });
			$("#wizard").attr("onclick","addComment()");
		});
		
		$('#putUser,#putUsuario').on('click', function() { 
			$('#serviceLocation').val($mainurl + "users/{username}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y modifica los datos principales de dicho usuario."); // descripcion del servicio
			$('#serviceName').val("Modificar Usuario"); // nombre del servicio
			//$('#wizard').click(function(){ editUser(); });
			$("#wizard").attr("onclick","editUser()");
		});
		
		$('#putFollower,#putSeguidor').on('click', function() { 
			$('#serviceLocation').val($mainurl + "users/{follower}/relationship/{followed}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe dos nombres de usuario, y crea una relación seguidor-seguido entre dichos usuarios en la red social."); // descripcion del servicio
			$('#serviceName').val("Seguir a Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#putPost,#putPublicacion').on('click', function() {
			$('#serviceLocation').val($mainurl + "posts/{id}/sharing/{username}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un id de una publicación y un nombre de usuario, y comparte dicha publicación en el perfil del usuario."); // descripcion del servicio
			$('#serviceName').val("Compartir Publicación"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#deleteUser,#deleteUsuario').on('click', function() {
			$('#serviceLocation').val($mainurl + "users/{username}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe un nombre de usuario y elimina dicho usuario de la red social."); // descripcion del servicio
			$('#serviceName').val("Eliminar Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$('#deleteFollower,#deleteSeguidor').on('click', function() { 
			$('#serviceLocation').val($mainurl + "users/{follower}/relationship/{followed}"); // se modifica el valor del url
			$('#serviceDescription').val("     Recibe dos nombres de usuario, y elimina la relación seguidor-seguido entre dichos usuarios en la red social."); // descripcion del servicio
			$('#serviceName').val("Dejar de Seguir a Usuario"); // nombre del servicio
			$("#wizard").attr("onclick","vacio()");
		});
		
		$("#accept1").on("click", function() {
			var value = $("#input1").val();
			var name = $("#input1").attr('name');
			var value1 = $("#input2").val();
			var name1 = $("#input2").attr('name');
			var value2 = $("#input3").val();
			var name2 = $("#input3").attr('name');
			var value3 = $("#input4").val();
			var name3 = $("#input4").attr('name');
			var string = '{ "' + name + '" : "' + value + 
						 '", "'+ name1 +'" : "'+ value1 +
						 '", "'+ name2 +'" : "'+ value2 +
						 '", "'+ name3 +'" : "'+ value3 + '" }';
			var json =  jQuery.parseJSON(string);
			$request.setValue(JSON.stringify(json, null, '\t'));
		});

		$("#accept2").on("click", function() {
			var value5 = $("#input5").val();
			var name5 = $("#input5").attr('name');
			var value6 = $("#input6").val();
			var name6 = $("#input6").attr('name');
			var string = '{ "' + name5 + '" : "' + value5 + 
						 '", "'+ name6 + '" : "' + value6 + '" }';
			var json =  jQuery.parseJSON(string);
			$request.setValue(JSON.stringify(json, null, '\t'));
		});

		$("#accept3").on("click", function() {
			var value7 = $("#input7").val();
			var name7 = $("#input7").attr('name');
			var value8 = $("#input8").val();
			var name8 = $("#input8").attr('name');
			var value9 = $("#input9").val();
			var name9 = $("#input9").attr('name');
			var textareaValue = $("#textarea1").val();
			var textareaName = $("#textarea1").attr('name');
			var string = '{ "' + name7 + '" : "' + value7 + 
						 '", "'+ name8 + '" : "' + value8 +
						 '", "'+ name9 + '" : "' + value9 + 
						 '", "'+ textareaName + '" : "' + textareaValue + '" }';
			var json =  jQuery.parseJSON(string);
			$request.setValue(JSON.stringify(json, null, '\t'));
		});

		$("#accept4").on("click", function() {
			var value10 = $("#input10").val();
			var name10 = $("#input10").attr('name');
			var value11 = $("#input11").val();
			var name11 = $("#input11").attr('name');
			var value12 = $("#input12").val();
			var myString = value12.split(",");
			var name12 = $("#input12").attr('name');
			var value13 = $("#input13").val();
			var name13 = $("#input13").attr('name');
			var list = JSON.stringify(myString);
			var b64 = utf8_to_b64(value13);
			var string = '{ "' + name10 + '" : "' + value10 + 
						 '", "'+ name11 + '" : "' + value11 +
						 '", "'+ name12 + '" : ' + list +
						 ', "'+ name13 + '" : "' + b64 + '" }';
			var json =  jQuery.parseJSON(string);
			$request.setValue(JSON.stringify(json, null, '\t'));
		});


		$("#accept5").on("click", function() {
			var value14 = $("#input14").val();
			var name14 = $("#input14").attr('name');
			var value15 = $("#input15").val();
			var name15 = $("#input15").attr('name');
			var value16 = $("#input16").val();
			var name16 = $("#input16").attr('name');
			var string = '{ "' + name14 + '" : "' + value14 + 
						 '", "'+ name15 + '" : "' + value15 +
						 '", "'+ name16 + '" : "' + value16 + '" }';
			var json =  jQuery.parseJSON(string);
			$request.setValue(JSON.stringify(json, null, '\t'));
		});



		function utf8_to_b64(str) {
    		return window.btoa(unescape(encodeURIComponent(str))); }

		function b64_to_utf8(str) {
		    return decodeURIComponent(escape(window.atob(str))); }


		   var clientTarget = new ZeroClipboard( $("#target-to-copy1"), {
    moviePath: "http://www.paulund.co.uk/playground/demo/zeroclipboard-demo/zeroclipboard/ZeroClipboard.swf",
    debug: false
} );

clientTarget.on( "load", function(clientTarget)
{
    $('#flash-loaded').fadeIn();

    clientTarget.on( "complete", function(clientTarget, args) {
        clientTarget.setText( args.text );
        $('#target-to-copy1-text').fadeIn();
    } );
} );
		
	});