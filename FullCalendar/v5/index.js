var test;
var error = {
    message:'에러임'
};
var eventsArr = [
    {
        title:'대극장',
        start:'2021-12-12T14:30',
        end:'2021-12-14T14:30',
    },

];


var calendar = new FullCalendar.Calendar($('#calendar')[0],{
    locale:'ko',
    initialView:'dayGridMonth',
    themeSystem:'bootstrap',
    bootstrapFontAwesome:{
        prev:'fa-angle-left',
        next:'fa-angle-right',
    },
    dayMaxEventRows:true,
    customButtons:{
        addEventBtn:{
            bootstrapFontAwesome:'fa-plus',
            click:function(e,el){
                calendar.addEvent({
                    title: 'test',
                    start:'2021-12-15'
                });
            }
        },
        removeEventBtn:{
            bootstrapFontAwesome:'fa-minus',
            click:function(e,el){
                calendar.getEvents().forEach(function(v,i){
                    if(v.title == 'test'){
                        v.remove()
                    }
                });
            }
        }
    },
    events:function(info,sucCallback,failCallback){
        sucCallback(eventsArr)
        // failCallback(error);
    },
    
    
    moreLinkClassNames:function(a){
        return ['moreTest']
    },
    headerToolbar:{
        left:'addEventBtn removeEventBtn',
        center:'prevYear prev title next nextYear',
        right:'timeGridDay',
    },
    buttonText:{
    },

});
calendar.render();
