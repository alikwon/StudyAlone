var num = 5 / 2;

console.log(num);
console.log(Math.floor(num));

var i = 1;
$('#create').on('click',function(){
    if(i>10){
        alert('더이상 버튼을 늘릴 수 없습니다.');
        return false;
    }
    var id = 'btn_' + i;
    $('<button>').attr({'id': id, 'class': 'btn'})
                 .text('버튼'+i)
                 .css('background-color','#'+(i*1111)+'FF')
                 .appendTo('div#test');
    i++;
});
$('div#test').on('click','.btn',function(){
    $('#test_txt').css('color',$(this).css('background-color'));
});

