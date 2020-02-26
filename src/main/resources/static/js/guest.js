$(document).ready(function () {
    $('.btnReply').click(function(){
        // 버튼을 눌럿을 때 버튼의 id값
        var id = $(this).attr('id');
        reply(id);
    });
    $("button[name='replySave']").click(function(){
        alert('first');
        var x = $(this).attr('id');
        replySave(x);
    });
     function reply(id){
        // 버튼을 눌럿을 때 버튼의 id값
        var thisId = id;
        var txt = thisId.replace('btnReply_','');
        var txt2 = txt;
        var list = txt.split('_',4);
        // 십입 되어야할 문장
        var html =  '<form class="form-block">'
                    +'    <div class="row" style="padding:10px;background-color:#E6E6E6;border-radius:10px;">'
                    +'        <div class="col-xs-12 col-sm-6">'
                    +'            <div class="form-group fl_icon">'
                    +'                <div class="icon"><i class="fa fa-user"></i></div>'
                    +'                <input class="form-input" id="author_'+list[0]+'" type="text" placeholder="닉네임">'
                    +'            </div>'
                    +'        </div>'
                    +'        <div class="col-xs-12 col-sm-12">'
                    +'            <div class="form-group">'
                    +'                <input class="form-input" id="content_'+list[0]+'" type="text" placeholder="Your text"></input>'
                    +'            </div>'
                    +'        </div>'
                    +'        <button type="button" class="btn btn-primary" onclick="replySave(\''+txt+'\')"  style="color: white;">submit</button>'
                    +'    </div>'
                    +'</form>'
                    +'<br>';
        // 해당문이 삽입되어야 할 위치 id
        var targetId = 'commentReply_' + list[0];
        // 문장 삽입
        $('#'+targetId).html(html);
        $('#'+targetId).css("display","block")
    }
});
function replySave(x) {
        var list = x.split('_',4);
        var a = 'author_' + list[0];
        var b = 'content_' + list[0];
        var data = {
            author : $('#'+ a).val(),
            content : $('#'+ b).val(),
            grp : list[1],
            step : list[2],
            indent : list[3]
        };
        $.ajax({
            type: 'POST',
            url: '/api/reply',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            window.location.href = '/guest';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
};

//function replySave(){
//    alert('asdf');
//}