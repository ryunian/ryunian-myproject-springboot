var idcheck = false;
var pwcheck = false;
var main = {
    init : function () {
        var _this = this;
        $('#btn-overlap').on('click', function(){
            _this.overlap();
        });
        $('#btn-register').on('click', function(){
            if(idcheck && _this.validationCheck()){
                _this.register();
            }else if(!idcheck){
                alert('ID 중복체크를 해주세요');
            }
        });
    },
    validationCheck : function() {
        var idCheck = /^[0-9a-zA-Z]{5,15}$/;
        if(!$('#id').val()){
            alert('아이디를 입력해주세요');
            return false;
        }else if(!idCheck.test($('#id').val())){
            alter('아이디는 5자~15자리 사이로 만들어주세요.');
            return false;
        }else if(!$('#pw').val()){
            alert('비밀번호를 입력해주세요');
            return false;
        }else if($('#pw').val().length > 15 || $('#pw').val().length < 5){
            alert('비밀번호는 5 ~ 15 자리로 입력해주세요');
            return false;
        }else if($('#pw').val() != $('#pwCheck').val()){
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }else if(!$('#name').val()){
            alert('이름을 입력해주세요');
            return false;
        }else if(!$('#email').val()){
            alert('이메일을 입력해주세요');
            return false;
        }else{
            return true;
        }
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