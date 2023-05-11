// @ts-nocheck

$(function(){
    //選択肢を選んだ時
    $('.selectBtn').on('click',function(){

        //A,B,C,Dどれを押したかの判定 START
        var selections_array = ["A","B","C","D"];
        var selection = $('.selectBtn').index(this);
        var after_str = 'あなたの解答：'+ selections_array[selection];
        //A,B,C,Dどれを押したかの判定 END

        //あなたの解答：Xを表示する
        var str = document.getElementById("cite").innerHTML;
        str = str.replace(str, after_str);
        document.getElementById("cite").innerHTML = str;

        //解答を表示する
        var after_str2 = answer;
        var str = document.getElementById("answer").innerHTML;
        str = str.replace(str, after_str2);
        document.getElementById("answer").innerHTML = str;

        //解説を表示する
        var after_str3 = explanation;
        var str = document.getElementById("explanation").innerHTML;
        str = str.replace(str, after_str3);
        document.getElementById("explanation").innerHTML = str;

        document.getElementById("ansbg_explanation").style.display ="block";;

        document.getElementById("seikai").style.display ="block";

        document.getElementById("kaisetsu").style.display ="block";


    });

});


function Answer_Check(ans) {
    console.log(answer)
    console.log(ans)
    if(ans == answer) {
    var str = document.getElementById("clear").innerHTML;
    str = str.replace(str, "正解！");
    document.getElementById("clear").innerHTML = str;

            //描画
            let canvas = document.querySelector('#canvas_answer_front');
            let context = canvas.getContext('2d');
    
            context.beginPath();
            context.arc(187, 80, 68, 0, Math.PI * 2);
            context.strokeStyle = 'green';
            context.lineWidth = 3;
            context.stroke();
            canvas.classList.add('fadeout');
    } else {
    var str = document.getElementById("clear").innerHTML;
    str = str.replace(str, "<span style='color:red';>不正解！</span>");
    document.getElementById("clear").innerHTML = str;
    }
}