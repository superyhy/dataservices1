$(function () {
    map();
    function map() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('map_hunan'));
        var data = [
            {name: '长沙', value: 139},
            {name: '株洲', value: 170},
            {name: '湘潭', value: 178},
            {name: '衡阳', value: 169},
            {name: '衡山', value: 169},
            {name: '邵阳', value: 169},
            {name: '岳阳', value: 169},
            {name: '郴州', value: 169},
            {name: '永州', value: 150},
            {name: '娄底', value: 134},
            {name: '吉首', value: 156},
            {name: '凤凰', value: 146},
            {name: '常德', value: 146}

        ];
        var geoCoordMap = {
            '长沙':[113	,28.21],
            '株洲':[113.16,27.83],
            '湘潭':[112.91,27.87],
            '衡阳':[112.57,26.90],
            '衡山':[112.86,27.25],
            '邵阳':[111.5,27.22],
            '岳阳':[113.12,29.37],
            '郴州':[113,25.79],
            '永州':[111.63,26.22],
            '娄底':[111.96,27.71],
            '吉首':[109.71,28.3],
            '凤凰':[109.43,27.92],
            '常德':[111.69,29.05]

        };
        var convertData = function (data) {
            var res = [];
            for (var i = 0; i < data.length; i++) {
                var geoCoord = geoCoordMap[data[i].name];
                if (geoCoord) {
                    res.push({
                        name: data[i].name,
                        value: geoCoord.concat(data[i].value)
                    });
                }
            }
            return res;
        };

        option = {
            // backgroundColor: '#404a59',
            /***  title: {
        text: '实时行驶车辆',
        subtext: 'data from PM25.in',
        sublink: 'http://www.pm25.in',
        left: 'center',
        textStyle: {
            color: '#fff'
        }
    },**/
            tooltip : {
                trigger: 'item',
                formatter: function (params) {
                    if(typeof(params.value)[2] == "undefined"){
                        return params.name + ' : ' + params.value;
                    }else{
                        return params.name + ' : ' + params.value[2];
                    }
                }
            },

            geo: {
                map: 'hunan',
                label: {
                    emphasis: {
                        show: false
                    }
                },
                roam: false,//禁止其放大缩小
                itemStyle: {
                    normal: {
                        areaColor: '#4c60ff',
                        borderColor: '#002097'
                    },
                    emphasis: {
                        areaColor: '#293fff'
                    }
                }
            },
            series : [
                {
                    name: '消费金额',
                    type: 'scatter',
                    coordinateSystem: 'geo',
                    data: convertData(data),
                    symbolSize: function (val) {
                        return val[2] / 15;
                    },
                    label: {
                        normal: {
                            formatter: '{b}',
                            position: 'right',
                            show: false
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: '#ffeb7b'
                        }
                    }
                }

                /**
                 ,
                 {
            name: 'Top 5',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            data: convertData(data.sort(function (a, b) {
                return b.value - a.value;
            }).slice(0, 6)),
            symbolSize: function (val) {
                return val[2] / 20;
            },
            showEffectOn: 'render',
            rippleEffect: {
                brushType: 'stroke'
            },
            hoverAnimation: true,
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#ffd800',
                    shadowBlur: 10,
                    shadowColor: 'rgba(0,0,0,.3)'
                }
            },
            zlevel: 1
        }
                 **/
            ]
        };

        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }

})

