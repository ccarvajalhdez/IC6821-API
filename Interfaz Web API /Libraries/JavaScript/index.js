$(document)
  .ready(function() {

    $('.filter.menu .item')
      .tab();

    $('.ui.sidebar')
      .sidebar('attach events', '.launch.button');
    
    $('.overlay.sidebar')
      .sidebar({
        overlay: true
       })
      .sidebar('toggle');

    $('.ui.dropdown')
      .dropdown();

    $('.ui.accordion')
      .accordion();

    $('.ui.rating')
      .rating({
        clearable: true
      });

    $('.accordion a.item')
      .on('click', function() {
        if(!$(this).hasClass('dropdown')) {
          $(this)
            .addClass('active')
            .closest('.ui.menu')
            .find('.accordion a.item')
              .not($(this))
              .removeClass('active'); }
    });

  });

function addUser() {
  $('.addUser.modal')
    .modal('show'); }

function addComment() {
  $('.addComment.modal')
    .modal('show'); }

function addPost() {
  $('.addPost.modal')
    .modal('show'); }

function editUser() {
  $('.editUser.modal')
    .modal('show'); }

function searchPosts() {
  $('.searchPosts.modal')
    .modal('show'); }

function vacio() {
  $('.vacio.modal')
    .modal('show'); }
