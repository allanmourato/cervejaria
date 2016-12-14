$(function( ) {
	$(".js-decimal").maskMoney({decimal: ',', thousands: '.' });
})

$(function() {
	$(".js-inteiro").maskMoney({precision: 0, thousands: '.' });
})

$(function() {
	$('.js-status').bootstrapSwitch();
})

var nomeFoto = $('input[name=foto]');
var contentType = $('input[name=contentType]');


$(function () {
			var settings = {
				type: 'json',
				filelimit: 1,
				allow: '*.(jpg|jpeg|png)',
				action: '/cervejaria/fotos',
				complete: function (resposta) {
					
					
					
					var htmlFotoCervejaTemplate = $('#foto-cerveja').html();
					var template = Handlebars.compile(htmlFotoCervejaTemplate);
					var htmlFotoCerveja = template({nomeFoto: resposta.nome});
					
					
					$('#upload-drop').addClass('hidden');
					var containerFotoCerveja = $('.js-container-foto-cerveja');
					containerFotoCerveja.append(htmlFotoCerveja);
					
					nomeFoto.val(resposta.nome);
					contentType.val(resposta.contentType);
					
					$('.js-remove-foto').on('click', function () {
						$('.js-foto-cerveja').remove();
						$('#upload-drop').removeClass('hidden');
						nomeFoto.val('');
						contentType.val('');
					});
					
					if(nomeFoto.val()) {
						
						nomeFoto.val(resposta.nome);
						contentType.val(resposta.contentType);
						
						$('#upload-drop').addClass('hidden');
						var containerFotoCerveja = $('.js-container-foto-cerveja');
						containerFotoCerveja.append(htmlFotoCerveja);
						
						nomeFoto.val(resposta.nome);
						contentType.val(resposta.contentType);
						
					}
					
				}
		};
		
		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop($('#upload-drop'), settings);
});