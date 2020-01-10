$(function () {
    echart_1();
    echart_2();
    echart_21();
    echart_3();
    echart_4();

    function echart_1() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_1'));
        var xAxisData = ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'];
        var legendData=['2018年','2019年'];
        var title = "单位：μg/m3";//标题


        // for (var v = 0; v < legendData.length; v++) {
        //     var serie = {
        //         name: legendData[v],
        //         type: 'line',
        //         symbol: "circle",
        //         symbolSize: 10,
        //         data: metaDate[v]
        //     };
        //     serieData.push(serie);
        // }
        var colors = ["#036BC8", "#FFF", "#5EBEFC", "#2EF7F3"];
        var option = {
            // backgroundColor: '#0f375f',
            title: {
                text: title,
                textAlign: 'left',
                textStyle: {
                    color: "#fff",
                    fontSize: "12",
                    fontWeight: "bold"
                }
            },
            legend: {
                show: true,
                left: "center",
                data: legendData,
                y: "5%",
                itemWidth: 18,
                itemHeight: 12,
                textStyle: {
                    color: "#fff",
                    fontSize: 14
                },
            },
            toolbox: {
                orient: 'vertical',
                right: '1%',
                top: '20%',
                iconStyle: {
                    color: '#fff',
                    borderColor: '#fff',
                    borderWidth: 1,
                },
                feature: {
                    saveAsImage: {},
                    magicType: {
                        // show: true,
                        type: ['line','bar','stack','tiled']
                    }
                }
            },
            color: colors,
            grid: {
                left: '2%',
                top: "12%",
                bottom: "5%",
                right: "5%",
                containLabel: true
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                },
            },
            xAxis: [{
                type: 'category',
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: '#6173A3'
                    }
                },
                axisLabel: {
                    interval: 0,
                    textStyle: {
                        color: '#9ea7c4',
                        fontSize: 12
                    }
                },
                axisTick: {
                    show: false
                },
                data: xAxisData,
            }, ],
            yAxis: [{
                axisTick: {
                    show: false
                },
                splitLine: {
                    show: false
                },
                axisLabel: {
                    textStyle: {
                        color: '#9ea7c4',
                        fontSize: 12
                    }
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: '#6173A3'
                    }
                },
            }, ],
            series: [{
                name: "2018年",
                type: 'line',
                symbol: "circle",
                symbolSize: 10,
                data: []
            },
                {
                    name: "2019年",
                    type: 'line',
                    symbol: "circle",
                    symbolSize: 10,
                    data: []
                }]
        };

        //调用/getAqiFromHengYang

        $.ajax({
            type : "get",
            url : "/getAqiFromHengYang",
            dataType : "json",
            success : function(result) {
                myChart.setOption({
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '2018年',
                        data: result.aqiListFrom2018
                    },{
                        name: '2019年',
                        data: result.aqiListFrom2019
                    }]
                });
            }

        });
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echart_2() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_2'));

        option = {

            title: [{
                text: '2018年',
                left: 'center',
                textStyle: {
                    color: '#fff',
                    fontSize:'12'
                }

            }],
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)",
                position:function(p){   //其中p为当前鼠标的位置
                    return [p[0] + 10, p[1] - 10];
                }
            },
            legend: {

                top:'70%',
                itemWidth: 10,
                itemHeight: 10,
                data:[],
                textStyle: {
                    color: 'rgba(255,255,255,.5)',
                    fontSize:'12',
                }
            },
            series: [
                {
                    name:'2018年',
                    type:'pie',
                    center: ['50%', '42%'],
                    radius: ['40%', '60%'],
                    color: ['rgb(131,249,103)', '#1DB7E5','#FBFE27', '#FE5050'],
                    label: {show:false},
                    labelLine: {show:false},
                    data:[]
                }
            ]
        };

        var names=[];
        //调用（//getAirQualityFrom2018）接口获取数据
        $.ajax({
            type : "get",
            url : "/getAirQualityFrom2018",
            dataType : "json",
            success : function(result) {
                for(var i=0;i<result.length;i++){
                    names.push(result[i].name);
                }
                myChart.setOption({
                    legend:{data: names},
                    series:{data: result}
                })
            }
        });

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echart_21() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_21'));

        option = {

            title: [{
                text: '2019年',
                left: 'center',
                textStyle: {
                    color: '#fff',
                    fontSize:'12'
                }

            }],
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)",
                position:function(p){   //其中p为当前鼠标的位置
                    return [p[0] + 10, p[1] - 10];
                }
            },
            legend: {

                top:'70%',
                itemWidth: 10,
                itemHeight: 10,
                data:[],
                textStyle: {
                    color: 'rgba(255,255,255,.5)',
                    fontSize:'12',
                }
            },
            series: [
                {
                    name:'2019年',
                    type:'pie',
                    center: ['50%', '42%'],
                    radius: ['40%', '60%'],
                    color: ['rgb(131,249,103)', '#1DB7E5','#FBFE27', '#FE5050'],
                    label: {show:false},
                    labelLine: {show:false},
                    data:[]
                }
            ]
        };

        var names=[];
        //调用（//getAirQualityFrom2019）接口获取数据
        $.ajax({
            type : "get",
            url : "/getAirQualityFrom2019",
            dataType : "json",
            success : function(result) {
                for(var i=0;i<result.length;i++){
                    names.push(result[i].name);
                }
                myChart.setOption({
                    legend:{data: names},
                    series:{data: result}
                })
            }
        });

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echart_3() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_3'));  
        
        option = {
            // backgroundColor: "#404A59",
            color: ["#036BC8", "#5EBEFC", "#2EF7F3"],
        
            title: [{
                text: '',
                left: '1%',
                top: '6%',
                textStyle: {
                    color: '#fff'
                }
            }, {
                text: '',
                left: '83%',
                top: '6%',
                textAlign: 'center',
                textStyle: {
                    color: '#fff',
                    fontSize: 16
                }
            }],
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                top: '7%',
                textStyle: {
                    color: '#fff',
                },
                data: ['AQI', 'PM2.5', 'PM10']
            },
            grid: {
                left: '1%',
                right: '10%',
                top: '16%',
                bottom: '6%',
                containLabel: true
            },
            toolbox: {
                "show": false,
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                "axisLine": {
                    lineStyle: {
                        color: '#fff'
                    }
                },
                "axisTick": {
                    "show": false
                },
                axisLabel: {
                    textStyle: {
                        color: '#fff'
                    }
                },
                boundaryGap: false,
                data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月']
            },
            yAxis: {
                "axisLine": {
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine: {
                    show: false,
                    lineStyle: {
                        color: '#fff'
                    }
                },
                "axisTick": {
                    "show": false
                },
                axisLabel: {
                    textStyle: {
                        color: '#fff'
                    }
                },
                type: 'value'
            },
            series: [{
                name: 'AQI',
                smooth: true,
                type: 'line',
                symbolSize: 9,
                  symbol: 'circle',
                data: []
            }, {
                name: 'PM2.5',
                smooth: true,
                type: 'line',
                symbolSize: 9,
                  symbol: 'circle',
                data: []
            }, {
                name: 'PM10',
                smooth: true,
                type: 'line',
                symbolSize: 9,
                  symbol: 'circle',
                data: []
            }]
        }

        //调用 /getAirQualityByHengYang

        $.ajax({
            type : "get",
            url : "/getAirQualityByHengYang",
            dataType : "json",
            success : function(result) {
                myChart.setOption({
                    series: [{
                        // 根据名字对应到相应的系列
                        name: 'AQI',
                        data: result.aqiList
                    },{
                        name: 'PM2.5',
                        data: result.pm25List
                    },{
                        name: 'PM10',
                        data: result.pm10List
                    }]
                });
            }

        });

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echart_4() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_4'));

        option = {

            tooltip: {},
            grid: {
                top: '8%',
                left: '1%',
                right: '1%',
                bottom: '8%',
                containLabel: true,
            },
            legend: {
                itemGap: 50,
                data: ['AQI' ,'PM2.5'],
                textStyle: {
                    color: '#f9f9f9',
                    borderColor: '#fff'
                },
            },
            xAxis: [{
                type: 'category',
                boundaryGap: true,
                axisLine: { //坐标轴轴线相关设置。数学上的x轴
                    show: true,
                    lineStyle: {
                        color: '#f9f9f9'
                    },
                },
                axisLabel: { //坐标轴刻度标签的相关设置
                    textStyle: {
                        color: '#d1e6eb',
                        margin: 15,
                    },
                },
                axisTick: {
                    show: false,
                },
                data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月' ],
            }],
            yAxis: [{
                type: 'value',
                min: 0,
                // max: 140,
                splitNumber: 7,
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#0a3256'
                    }
                },
                axisLine: {
                    show: false,
                },
                axisLabel: {
                    margin: 20,
                    textStyle: {
                        color: '#d1e6eb',

                    },
                },
                axisTick: {
                    show: false,
                },
            }],
            series: [{
                name: 'AQI',
                type: 'line',
                // smooth: true, //是否平滑曲线显示
                // 			symbol:'circle',  // 默认是空心圆（中间是白色的），改成实心圆
                showAllSymbol: true,
                symbol: 'emptyCircle',
                symbolSize: 6,
                lineStyle: {
                    normal: {
                        color: "#28ffb3", // 线条颜色
                    },
                    borderColor: '#f0f'
                },
                label: {
                    show: true,
                    position: 'top',
                    textStyle: {
                        color: '#fff',
                    }
                },
                itemStyle: {
                    normal: {
                        color: "#28ffb3",

                    }
                },
                tooltip: {
                    show: false
                },
                areaStyle: { //区域填充样式
                    normal: {
                        //线性渐变，前4个参数分别是x0,y0,x2,y2(范围0~1);相当于图形包围盒中的百分比。如果最后一个参数是‘true’，则该四个值是绝对像素位置。
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(0,154,120,1)'
                        },
                            {
                                offset: 1,
                                color: 'rgba(0,0,0, 0)'
                            }
                        ], false),
                        shadowColor: 'rgba(53,142,215, 0.9)', //阴影颜色
                        shadowBlur: 20 //shadowBlur设图形阴影的模糊大小。配合shadowColor,shadowOffsetX/Y, 设置图形的阴影效果。
                    }
                },
                data: []
            }, {
                name: 'PM2.5',
                type: 'bar',
                barWidth: 20,
                tooltip: {
                    show: false
                },
                label: {
                    show: true,
                    position: 'top',
                    textStyle: {
                        color: '#fff',
                    }
                },
                itemStyle: {
                    normal: {
                        // barBorderRadius: 5,
                        // color: new echarts.graphic.LinearGradient(
                        //     0, 0, 0, 1,
                        //     [{
                        //             offset: 0,
                        //             color: '#14c8d4'
                        //         },
                        //         {
                        //             offset: 1,
                        //             color: '#43eec6'
                        //         }
                        //     ]
                        // )
                        color: function(params) {
                            var colorList = ['#0ec1ff', '#10cdff', '#12daff', '#15ebff', '#17f8ff', '#1cfffb', '#1dfff1'];
                            return colorList[params.dataIndex];
                        }
                    }
                },
                data: []
            }]
        };

        //调用 /getAirQualityByHengYang

        $.ajax({
            type : "get",
            url : "/getPm25AndAqiFrom2018",
            dataType : "json",
            success : function(result) {
                myChart.setOption({
                    series: [{
                        // 根据名字对应到相应的系列
                        name: 'AQI',
                        data: result.aqiList
                    },{
                        name: 'PM2.5',
                        data: result.pm25List
                    }]
                });
            }

        });

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });

    }

});