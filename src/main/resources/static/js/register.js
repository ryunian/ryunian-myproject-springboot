var idcheck = false;
var main = {
    init : function () {
        var _this = this;
        $('#btn-overlap').on('click', function(){
            _this.overlap();
        });
        $('#btn-register').on('click', function(){
            if(idcheck){
                _this.register();
            }else{
                alert('ID 중복체크를 해주세요');
            }
        });
    },
    overlap : function() {
        var id = $('#id').val();
        $.ajax({
            type: 'GET',
            url: '/api/check/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=urf-8'
        }).done(function(check){
            if(check){
                idcheck = true;
                alert('사용가능 합니다.');
            }else{
                idcheck = false;
                alert('아이디가 중복됩니다.')
            }
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    register : function() {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val(),
            name: $('#name').val(),
            email: $('#email').val()
        };
        $.ajax({
            type: 'POST',
            url: '/api/register',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(check){
            if(check == true){
                alert('회원가입 완료');
                window.location.href = '/loginPage';
            }else{
                alert('회원가입 실패');
                window.location.href = '/loginPage';
            }
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};
main.init();