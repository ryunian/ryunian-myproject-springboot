function sendEmail(){
    var data = {
        sender: $('#email').val(),
        title: $('#title').val(),
        content : $('#content').val()
    };
    $.ajax({
        type: 'POST',
        url: '/api/mail',
        dataType: 'json',
        contentType:'application/json; charset=utf-8',
        data: JSON.stringify(data)
        }).done(function(x){
            alert('메일이 보내졌습니다.');
            window.location.href = '/contact';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
};