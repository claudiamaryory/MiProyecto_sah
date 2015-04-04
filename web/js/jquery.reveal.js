


(function($) {
	$('a[data-reveal-id]').live('click', function(e) {
		e.preventDefault();
		var modalLocation = $(this).attr('data-reveal-id');
		$('#'+modalLocation).reveal($(this).data());
	});
    $.fn.reveal = function(options) {
        
        var defaults = {  
	    	animation: 'fadeAndPop', //fade, fadeAndPop, none
                animationspeed: 700, //la rapidez animtions son
                closeonbackgroundclick: true, //si hace clic en el fondo será modal cerca?
                dismissmodalclass: 'close-reveal-modal' //la clase de un botón o elemento que va a cerrar una modal abierta
    	}; 
        var options = $.extend({}, defaults, options); 
	
        return this.each(function() {
        	var modal = $(this),
        		topMeasure  = parseInt(modal.css('top')),
				topOffset = modal.height() + topMeasure,
          		locked = false,
				modalBG = $('.reveal-modal-bg');

			if(modalBG.length == 0) {
				modalBG = $('<div class="reveal-modal-bg" />').insertAfter(modal);
			}	
			//Entrada Animaciones
			modal.bind('reveal:open', function () {
			  modalBG.unbind('click.modalEvent');
				$('.' + options.dismissmodalclass).unbind('click.modalEvent');
				if(!locked) {
					lockModal();
					if(options.animation == "fadeAndPop") {
						modal.css({'top': $(document).scrollTop()-topOffset, 'opacity' : 0, 'visibility' : 'visible'});
						modalBG.fadeIn(options.animationspeed/2);
						modal.delay(options.animationspeed/2).animate({
							"top": $(document).scrollTop()+topMeasure + 'px',
							"opacity" : 1
						}, options.animationspeed,unlockModal());					
					}
					if(options.animation == "fade") {
						modal.css({'opacity' : 0, 'visibility' : 'visible', 'top': $(document).scrollTop()+topMeasure});
						modalBG.fadeIn(options.animationspeed/2);
						modal.delay(options.animationspeed/2).animate({
							"opacity" : 1
						}, options.animationspeed,unlockModal());					
					} 
					if(options.animation == "none") {
						modal.css({'visibility' : 'visible', 'top':$(document).scrollTop()+topMeasure});
						modalBG.css({"display":"block"});	
						unlockModal()				
					}
				}
				modal.unbind('reveal:open');
			}); 	

			//Cierre de Animación
			modal.bind('reveal:close', function () {
			  if(!locked) {
					lockModal();
					if(options.animation == "fadeAndPop") {
						modalBG.delay(options.animationspeed).fadeOut(options.animationspeed);
						modal.animate({
							"top":  $(document).scrollTop()-topOffset + 'px',
							"opacity" : 0
						}, options.animationspeed/2, function() {
							modal.css({'top':topMeasure, 'opacity' : 1, 'visibility' : 'hidden'});
							unlockModal();
						});					
					}  	
					if(options.animation == "fade") {
						modalBG.delay(options.animationspeed).fadeOut(options.animationspeed);
						modal.animate({
							"opacity" : 0
						}, options.animationspeed, function() {
							modal.css({'opacity' : 1, 'visibility' : 'hidden', 'top' : topMeasure});
							unlockModal();
						});					
					}  	
					if(options.animation == "none") {
						modal.css({'visibility' : 'hidden', 'top' : topMeasure});
						modalBG.css({'display' : 'none'});	
					}		
				}
				modal.unbind('reveal:close');
			});     
   	
/*---------------------------
 Abra y añadir detectores de cierre
----------------------------*/
        	//Abrir Modal Inmediatamente
    	modal.trigger('reveal:open')
			
			//Close Modal Listeners
			var closeButton = $('.' + options.dismissmodalclass).bind('click.modalEvent', function () {
			  modal.trigger('reveal:close')
			});
			//esta funcion espara cerrar el modal cuando se da click fueradel cuadro del  dialogo
//			if(options.closeonbackgroundclick) {
//				modalBG.css({"cursor":"pointer"})
//				modalBG.bind('click.modalEvent', function () {
//				  modal.trigger('reveal:close')
//				});
//			}
			$('body').keyup(function(e) {
        		if(e.which===27){// 27 es el código de tecla para la tecla Escape
                            modal.trigger('reveal:close');
                        }
			});
                        //Cancelar al eliminar
                         $('#close').click(function(){
                           modal.trigger('reveal:close'); 
                         });
                         //cerrar modal al registrar
                         $('#cerrarA').click(function(){
                           modal.trigger('reveal:close'); 
                         });
                         //cerrar modal al registrar
                         $('#cerrarR').click(function(){
                           modal.trigger('reveal:close'); 
                         });
			
			
/*---------------------------
 Animations Locks
----------------------------*/
			function unlockModal() { 
				locked = false;
			}
			function lockModal() {
				locked = true;
			}	
			
        });//each call
    }//orbit plugin call
})(jQuery);
        
