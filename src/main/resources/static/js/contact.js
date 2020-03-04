function sendEmail(){
    var data = {
        sender: $('#email').val(),
        title: $('#title').val(),
        content : $('#content').val()
    };
    $('#email-btn').attr('disabled', true);
    $('#email-btn').text('메일을 보내는 중입니다...');
    $('#email-span').css('display', 'inline-block');
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