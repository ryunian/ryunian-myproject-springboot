$(".custom-file-input").on("change", function() {
    var fileName = "";
    if(this.files.length > 1){
        var fileName = $(this).val().split("\\").pop() + " 외  " + (this.files.length-1) + "개";
    }else{
        var fileName = $(this).val().split("\\").pop();
    }
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        var formData = new FormData();
        formData.append('title', $('#title').val());
        formData.append('author',  $('#author').val());
        formData.append('content', $('#content').val());
        var files = $('#files')[0].files;
        for(var i=0; i<files.length; ++i){
            formData.append('files', files[i]);
        }
        $.ajax({
            type: 'POST',
            url: '/api/posts',
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            data: formData
//            dataType: 'json',
//            contentType:'application/json; charset=utf-8',
//            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/board';
        }).fail(function (error) {
            alert(JSON.stringify(error));
    });
},
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/board';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/board';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};
main.init();