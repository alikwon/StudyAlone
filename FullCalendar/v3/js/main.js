var draggedEventIsAllDay;
var activeInactiveWeekends = true;

function getDisplayEventDate(event) {

	var displayEventDate;

	if (event.allDay == false) {
		var startTimeEventInfo = moment(event.start).format('HH:mm');
		var endTimeEventInfo = moment(event.end).format('HH:mm');
		displayEventDate = startTimeEventInfo + " - " + endTimeEventInfo;
	} else {
		displayEventDate = "하루종일";
	}

	return displayEventDate;
}

function filtering(event) {
	var show_username = true;
	var show_type = true;

	var username = $('input:checkbox.filter:checked').map(function () {
		return $(this).val();
	}).get();
	var types = $('#type_filter').val();

	show_username = username.indexOf(event.username) >= 0;

	if (types && types.length > 0) {
		if (types[0] == "all") {
			show_type = true;
		} else {
			show_type = types.indexOf(event.type) >= 0;
		}
	}

	return show_username && show_type;
}

function calDateWhenResize(event) {

	var newDates = {
		startDate: '',
		endDate: ''
	};

	if (event.allDay) {
		newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');
		newDates.endDate = moment(event.end._d).subtract(1, 'days').format('YYYY-MM-DD');
	} else {
		newDates.startDate = moment(event.start._d).format('YYYY-MM-DD HH:mm');
		newDates.endDate = moment(event.end._d).format('YYYY-MM-DD HH:mm');
	}

	return newDates;
}

/*function calDateWhenDragnDrop(event) {
  // 드랍시 수정된 날짜반영
  var newDates = {
	startDate: '',
	endDate: ''
  }

  // 날짜 & 시간이 모두 같은 경우
  if(!event.end) {
	event.end = event.start;
  }

  //하루짜리 all day
  if (event.allDay && event.end === event.start) {
	newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');
	newDates.endDate = newDates.startDate;
  }

  //2일이상 all day
  else if (event.allDay && event.end !== null) {
	newDates.startDate = moment(event.start._d).format('YYYY-MM-DD');
	newDates.endDate = moment(event.end._d).subtract(1, 'days').format('YYYY-MM-DD');
  }

  //all day가 아님
  else if (!event.allDay) {
	newDates.startDate = moment(event.start._d).format('YYYY-MM-DD HH:mm');
	newDates.endDate = moment(event.end._d).format('YYYY-MM-DD HH:mm');
  }

  return newDates;
}*/
var kjjidx = 0;
var calendar = $('#calendar').fullCalendar({
	// 일정 받아옴 
	// events: function (start, end, timezone, callback) {
	// 	var events=[];

	// 	$.each(scheduleList, function(idx, val){
	// 		var bg = !val.bg ? '#fd6b00' : val.bg;
	// 		events.push({
	// 	    	 "title": val.name,
	// 	    	 "start": val.date,
	// 	    	 "end": val.date,
	// 	    	 "backgroundColor": bg,
	// 	    	 "textColor": '#fff',
	// 		});
	// 	});

	// 	$.each(closeWeek, function(idx, val){
	// 		var bg = !val.bg ? '#fd6b00' : val.bg;
	// 		events.push({
	// 			 "className": "fc-close",
	// 	    	 "title": val.cont,
	// 	    	 "start": '09:00',
	// 	    	 "end": '10:00',
	// 	    	 "dow": val.dow.split(","),
	// 	    	 "backgroundColor": "transparent",
	// 	    	 "textColor": '#F33131',
	// 		});
	// 	});

	// 	$.each(closeEtc, function(idx, val){
	// 		var bg = !val.bg ? '#fd6b00' : val.bg;
	// 		events.push({
	// 			 "className": "fc-close",
	// 	    	 "title": val.cont,
	// 	    	 "start": val.start,
	// 	    	 "end": val.end,
	// 	    	 "backgroundColor": "transparent",
	// 	    	 "textColor": '#F33131',
	// 		});
	// 	});

	// 	callback(events);
	// },

	/*eventRender: function (event, element, view) {
  
	  //일정에 hover시 요약
	  element.popover({
		title: $('<div />', {
		  class: 'popoverTitleCalendar',
		  text: event.title
		}).css({
		  'background': event.backgroundColor,
		  'color': event.textColor
		}),
		content: $('<div />', {
			class: 'popoverInfoCalendar'
		  }).append('<p><strong>등록자:</strong> ' + event.username + '</p>')
		  .append('<p><strong>구분:</strong> ' + event.type + '</p>')
		  .append('<p><strong>시간:</strong> ' + getDisplayEventDate(event) + '</p>')
		  .append('<div class="popoverDescCalendar"><strong>설명:</strong> ' + event.description + '</div>'),
		delay: {
		  show: "800",
		  hide: "50"
		},
		trigger: 'hover',
		placement: 'top',
		html: true,
		container: 'body'
	  });
  
	  return filtering(event);
  
	},
  
  
	
	views: {
		month: {
			columnFormat: 'dddd'
		},
		agendaWeek: {
			columnFormat: 'M/D ddd',
			titleFormat: 'YYYY년 M월 D일',
			eventLimit: false
		},
		agendaDay: {
			columnFormat: 'dddd',
			eventLimit: false
		},
		listWeek: {
			columnFormat: ''
	  }
	},
	*/


	/*var data = JSON.parse(response);
	if (data.length > 0) {
		for (var i = 0; i < data.length; i++) {
			
			data[i].subCnt + "/" + data[i].totCnt;
			data[i].date
		}
	}	 */
	//가용인원 / 총인원
	// 0 / 20 다 스케줄 배정
	//20 / 20 전체 스케줄 배정
	customButtons: {
		requestBtn: {
			text: '커스텀',
			click: function () {
				// activeInactiveWeekends ? activeInactiveWeekends = false : activeInactiveWeekends = true;
				// $('#calendar').fullCalendar('option', {
				// 	weekends: activeInactiveWeekends
				// });
			}
		}
	},
	header: {
		left: 'today, listDay, agendaDay',
		center: 'prev,  title, next',
		right: 'month, requestBtn'
	},
	events: [
		{
			title: '타이틀 ' + kjjidx++,
			start: "2021-12-06",
			end: "2021-12-07",
			backgroundColor: "#3f68b1",
			textColor: "#fff",
			name:"공연하는 날",
		},
		{
			title: '타이틀 ' + kjjidx++,
			start: "2021-12-10",
			end: "2021-12-10",
			backgroundColor: "#3f68b1",
			textColor: "#fff",
		},
		{
			title: '타이틀 ' + kjjidx++,
			start: "2021-12-10",
			end: "2021-12-10",
			backgroundColor: "#3f68b1",
			textColor: "#fff"
		},
		{
			title: '타이틀 ' + kjjidx++,
			start: "2021-12-10",
			end: "2021-12-10",
			backgroundColor: "#3f68b1",
			textColor: "#fff"
		},
		{
			title: '타이틀 ' + kjjidx++,
			start: "2021-12-10",
			end: "2021-12-10",
			backgroundColor: "#3f68b1",
			textColor: "#fff"
		},
		{
			title: '타이틀 ' + kjjidx++,
			start: "2021-12-09",
			end: "2021-12-09",
			backgroundColor: "#3f68b1",
			textColor: "#fff",
			rendering: 'background'
		},
	],
	eventAfterAllRender: function (view) {
		if (view.name == "month") {
			$(".fc-content").css('height', 'auto');
		}
	},
	eventAfterRender: function (e, $el, view) {
		// console.log(e)
		// console.log(el)
		// console.log(view)
	},
	eventRender: function (e, $el, view) {
		// if(e.title=='타이틀 0'){
		// 	console.log(e)
		// 	console.log(el)
		// 	console.log(view)
// 
		// }
		if (e.rendering == 'background') {
			$el.addClass('customBackground');
			$el.text('휴무일')
			return $el;
		}
		

	},
	
	eventClick: function (obj, e, view) {
		var target = $(e.target);
		var p = $(target.closest('td')).offset();

		var ptop = p.top-122;
		var pleft = p.left-35;
		console.log(obj);
		$('.fc-popover').remove();
		$('<div>')
			.addClass('fc-popover fc-more-popover eventPopup')
			.css({top:ptop,left:pleft})
			.appendTo('.fc-month-view');
		$('<div>')
			.addClass('fc-header fc-widget-header')
			.appendTo('.eventPopup');
		$('<div>')
			.addClass('fc-body fc-widget-content')
			.appendTo('.eventPopup');
		$('<div>')
			.addClass('fc-event-container')
			.appendTo('.eventPopup > .fc-widget-content');
		var headerHtml =
		'		<a href="javascript:void(0)" class="fc-close fc-icon fc-icon-x customClose"></a>'+
		'		<span class="fc-title">'+obj.title+'</span>'+
		'		<div class="fc-clear"></div>';
		$('.eventPopup > .fc-header').html(headerHtml);

		var bodyHtml = 
		'				<div class="fc-content"> '+
		'					<span class="fc-event-dot" style="background-color:'+obj.backgroundColor+'"></span>'+
		// '			<a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end" style="background-color:#3f68b1;color:#fff">'+
		'					<div class="fc-title">장소 : '+obj.title+'</div>'+
		'					<div>날짜 : '+obj.start.format()+'</div>'+
		'					<div>행사명 : '+obj.name+'</div>'+
		'				</div>';
		// '			</a>'

		$('.eventPopup .fc-event-container').html(bodyHtml);
		
		$('.customClose').on('click',function(){
			$('.fc-popover').remove();
		});
		$('.eventPopup').on('click',function(){
			$('.fc-popover').remove();
		});
		$('.eventPopup').on('mouseleave',function(){
			$('.fc-popover').remove();
		});
	},
	//일정 리사이즈
	/*eventResize: function (event, delta, revertFunc, jsEvent, ui, view) {
	  $('.popover.fade.top').remove();
  
	  *//** 리사이즈시 수정된 날짜반영
* 하루를 빼야 정상적으로 반영됨. *//*
				  var newDates = calDateWhenResize(event);
				 
				  //리사이즈한 일정 업데이트
				  $.ajax({
					type: "get",
					url: "",
					data: {
					  //id: event._id,
					  //....
					},
					success: function (response) {
					  alert('수정: ' + newDates.startDate + ' ~ ' + newDates.endDate);
					}
				  });
				 
				 },*/

	/*eventDragStart: function (event, jsEvent, ui, view) {
	  draggedEventIsAllDay = event.allDay;
	},
  */
	//일정 드래그앤드롭
	/*eventDrop: function (event, delta, revertFunc, jsEvent, ui, view) {
	  $('.popover.fade.top').remove();
  
	  //주,일 view일때 종일 <-> 시간 변경불가
	  if (view.type === 'agendaWeek' || view.type === 'agendaDay') {
		if (draggedEventIsAllDay !== event.allDay) {
		  alert('드래그앤드롭으로 종일<->시간 변경은 불가합니다.');
		  location.reload();
		  return false;
		}
	  }*/

	// 드랍시 수정된 날짜반영
	/*  var newDates = calDateWhenDragnDrop(event);
  
	  //드롭한 일정 업데이트
	  $.ajax({
		type: "get",
		url: "",
		data: {
		  //...
		},
		success: function (response) {
		  alert('수정: ' + newDates.startDate + ' ~ ' + newDates.endDate);
		}
	  });
  
	},*/

	select: function (startDate, endDate, jsEvent, view) {

		$(".fc-body").unbind('click');
		$(".fc-body").on('click', 'td', function (e) {

			$("#contextMenu")
				.addClass("contextOpened")
				.css({
					display: "block",
					left: e.pageX,
					top: e.pageY
				});
			return false;
		});

		var today = moment();

		if (view.name == "month") {
			startDate.set({
				hours: today.hours(),
				minute: today.minutes()
			});
			startDate = moment(startDate).format('YYYY-MM-DD HH:mm');
			endDate = moment(endDate).subtract(1, 'days');

			endDate.set({
				hours: today.hours() + 1,
				minute: today.minutes()
			});
			endDate = moment(endDate).format('YYYY-MM-DD HH:mm');
		} else {
			startDate = moment(startDate).format('YYYY-MM-DD HH:mm');
			endDate = moment(endDate).format('YYYY-MM-DD HH:mm');
		}

		//날짜 클릭시 카테고리 선택메뉴
		var $contextMenu = $("#contextMenu");
		$contextMenu.on("click", "a", function (e) {
			e.preventDefault();

			//닫기 버튼이 아닐때
			if ($(this).data().role !== 'close') {
				newEvent(startDate, endDate, $(this).html());
			}

			$contextMenu.removeClass("contextOpened");
			$contextMenu.hide();
		});

		$('body').on('click', function () {
			$contextMenu.removeClass("contextOpened");
			$contextMenu.hide();
		});

	},

	//이벤트 클릭시 수정이벤트
	/* eventClick: function (event, jsEvent, view) {
	   editEvent(event);
	 },*/

	locale: 'ko',
	timezone: "local",
	nextDayThreshold: "09:00:00",
	allDaySlot: true,
	displayEventTime: false, // 이벤트 시간 노출여부
	displayEventEnd: true,
	firstDay: 0, //월요일이 먼저 오게 하려면 1
	weekNumbers: false,
	selectable: true,
	weekNumberCalculation: "ISO",
	eventLimit: true,
	views: {
		month: {
			eventLimit: 3
		}
	},
	eventLimitClick: 'popover', //popover
	navLinks: true,
	defaultDate: new Date(),
	timeFormat: 'HH:mm',
	defaultTimedEventDuration: '01:00:00',
	editable: false,
	minTime: '00:00:00',
	maxTime: '24:00:00',
	slotLabelFormat: 'HH:mm',
	weekends: true,
	nowIndicator: true,
	dayPopoverFormat: 'MM/DD dddd',
	longPressDelay: 0,
	eventLongPressDelay: 0,
	selectLongPressDelay: 0
});
