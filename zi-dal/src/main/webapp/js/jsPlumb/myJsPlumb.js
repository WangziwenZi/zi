(function ($) {
    id = 1;
    var methods = {
        init: function () {
            return $(this).each(function () {

            })
        },
        //每个节点菜单
        nodeMenu: function () {
            return this.each(function () {
                tool.menu($(this), 'svg', function (key, options) {
                    var m = "clicked: " + key + " on " + $(this).text();
                    window.console && console.log(m) || alert(m);
            }, {
                    "edit": {name: $(this).prop("id"), icon: "edit"},
                    "cut": {name: "Cut", icon: "cut"},
                    "copy": {name: "Copy", icon: "copy"},
                    "paste": {name: "Paste", icon: "paste"},
                    "delete": {name: "Delete", icon: "delete"},
                    "sep1": "---------",
                        "quit": {
                        name: "Quit", icon: function ($element, key, item) {
                            return 'context-menu-icon context-menu-icon-quit';
                        }
                    }
                })
            })
        },
        bodyMenu: function () {
            var instance = arguments[0];
            return this.each(function () {
                tool.menu($(this), '#canvas', function (key, options) {
                    arguments[1] = instance;
                    menu[key].apply($(this), arguments);
                }, {
                    "nodeAdd": {name: "添加流程", icon: "add"},
                    "cut": {name: "Cut", icon: "cut"},
                    "copy": {name: "Copy", icon: "copy"},
                    "paste": {name: "Paste", icon: "paste"},
                    "delete": {name: "Delete", icon: "delete"},
                    "sep1": "---------",
                    "quit": {
                        name: "Quit", icon: function ($element, key, item) {
                            return 'context-menu-icon context-menu-icon-quit';
                        }
                    }
                })
            })
        }, addNode: function () {
            //创建node
            var instance = arguments[0];
            var params = arguments[1];
            var code = tool.nodeTemplate(this, params.type, id++, params.node);
            // make all the window divs draggable
            instance.draggable(jsPlumb.getSelector(".flowchart-demo .window"), {grid: [20, 20]});
            /*var source = ["TopCenter", "BottomCenter"];
            var target = ["LeftMiddle", "RightMiddle"];
            //请求
            $.each(source, function (k, v) {
                var sourceUUID = code + v;
                instance.addEndpoint("flowchart" + code, sourceEndpoint, {
                    anchor: v, uuid: sourceUUID
                });
            })
            //接受
            $.each(target, function (k, v) {
                var sourceUUID = code + v;
                instance.addEndpoint("flowchart" + code, targetEndpoint, {
                    anchor: v, uuid: sourceUUID
                });
            })*/

            instance.makeSource(code, sourceEndpoint);
            instance.makeTarget(code, { //设置连接的目标，就是那一头
                dropOptions: { hoverClass: "dragHover" },
                anchor: "Continuous",
                allowLoopback: true
            });

            // listen for new connections; initialise them the same way we initialise the connections at startup.
            instance.bind("connection", function (connInfo, originalEvent) {
                init(connInfo.connection);
            });

            // THIS DEMO ONLY USES getSelector FOR CONVENIENCE. Use your library's appropriate selector
            // method, or document.querySelectorAll:
            //jsPlumb.draggable(document.querySelectorAll(".window"), { grid: [20, 20] });

            // connect a few up
            // instance.connect({uuids: ["Window2BottomCenter", "Window3TopCenter"], editable: true});
            // instance.connect({uuids: ["Window2LeftMiddle", "Window4LeftMiddle"], editable: true});
            // instance.connect({uuids: ["Window4TopCenter", "Window4RightMiddle"], editable: true});
            // instance.connect({uuids: ["Window3RightMiddle", "Window2RightMiddle"], editable: true});
            // instance.connect({uuids: ["Window4BottomCenter", "Window1TopCenter"], editable: true});
            // instance.connect({uuids: ["Window3BottomCenter", "Window1BottomCenter"], editable: true});
            //

            //
            // listen for clicks on connections, and offer to delete connections on click.
            //
            instance.bind("click", function (conn, originalEvent) {
                // if (confirm("Delete connection from " + conn.sourceId + " to " + conn.targetId + "?"))
                //   instance.detach(conn);
                conn.toggleType("basic");
            });

            instance.bind("connectionDrag", function (connection) {
                console.log("connection " + connection.id + " is being dragged. suspendedElement is ", connection.suspendedElement, " of type ", connection.suspendedElementType);
            });

            instance.bind("connectionDragStop", function (connection) {
                console.log("connection " + connection.id + " was dragged");
            });

            instance.bind("connectionMoved", function (params) {
                console.log("connection " + params.connection.id + " was moved");
            });
        }
    }
    var tool = {
        menu: function (_this, selector, callback, items) {
            _this.contextMenu({
                selector: selector,
                callback: callback,
                items: items
            });
        }, serializeJson: function () {
            var result = {};
            $.each($(this).serializeArray(), function (k, v) {
                result[v.name] = v.value;
            })
            return result;
        }, svg: function (tagName) {
            var svgns = "http://www.w3.org/2000/svg";
            return $(document.createElementNS(svgns, tagName));
        }, nodeTemplate: function (_this, method, id, title) {
            var code = "Window" + id;
            var node = template[method](title, code);
            $(_this).append(node);
            return node;
        }, text01: function (params) {
            var div1 = $('<div class="form-group"></div>');
            var div2 = $('<div class="input-group"></div>');
            var div2_1 = $('<div class="input-group-addon"></div>');
            div2_1.html(params.title);
            var input = $('<input class="form-control" type="text" />');
            input.attr("name", params.name);
            div2.append(div2_1).append(input);
            div1.append(div2);
            return div1;
        }, radio01: function (params) {
            var div1 = $('<div class="radio-inline"></div>');
            var label = $('<label></label>');
            var input = $('<input type="radio" name="' + params.name + '" value="' + params.value + '"/>');
            var p = $('<p>' + params.title + '</p>');
            label.append(input);
            label.append(p);
            div1.append(label);
            return div1;
        }
    }

    // this is the paint style for the connecting lines..
    var connectorPaintStyle = {
            strokeWidth: 2,
            stroke: "#61B7CF",
            joinstyle: "round",
            outlineStroke: "white",
            outlineWidth: 2
        },
        // .. and this is the hover style.
        connectorHoverStyle = {
            strokeWidth: 3,
            stroke: "#216477",
            outlineWidth: 5,
            outlineStroke: "white"
        },
        endpointHoverStyle = {
            fill: "#216477",
            stroke: "#216477"
        },
        // the definition of source endpoints (the small blue ones)
        sourceEndpoint = {
            filter: ".outer",
            anchor:"AutoDefault",
            endpoint:"Dot",
            paintStyle: {
                    stroke: "#7AB02C",
                    fill: "transparent",
                    radius: 3,
                    strokeWidth: 1
            },
            connector: ["Flowchart", {stub: [40, 60], gap: 10, cornerRadius: 5, alwaysRespectStubs: true}],
            connectorStyle: connectorPaintStyle,
            hoverPaintStyle: endpointHoverStyle,
            connectorHoverStyle: connectorHoverStyle,
            events: {
                "dblclick": function (params) {
                    /*jsPlumbToolkit.Dialogs.show({
                        id: "dlgConfirm",
                        data: {
                            msg: "Delete Edge"
                        },
                        onOK: function () {
                            toolkit.removeEdge(params.edge);
                        }
                    });*/
                }
            },
            overlays: [
                ["Label", {
                    location: [0.5, 1.5],
                    label: "Drag",
                    cssClass: "endpointSourceLabel",
                    visible: false ,
                    events:{
                        click:function(params){
                            console.info(params.edge);
                        }
                    }
                }],[ "Arrow", { location: 1, width: 10, length: 10 }],
                [ "Arrow", { location: 0.3, width: 10, length: 10 }]
            ]
        },
        // the definition of target endpoints (will appear when the user drags a connection)
        targetEndpoint = {
            endpoint: "Dot",
            paintStyle: {fill: "#7AB02C", radius: 3},
            hoverPaintStyle: endpointHoverStyle,
            maxConnections: -1,
            dropOptions: {hoverClass: "hover", activeClass: "active"},
            // dropOptions: { hoverClass: "dragHover" },
            anchor: "Continuous",
            allowLoopback: true,
            overlays: [
                ["Label", {
                    location: [0.5, -0.5],
                    label: "Drop",
                    cssClass: "endpointTargetLabel",
                    visible: false
                }]
            ]
        },
        init = function (connection) {
            connection.getOverlay("label").setLabel(connection.sourceId.substring(15) + "-" + connection.targetId.substring(15));
        };

    var menu = {
        nodeAdd: function () {
            _this = $(this);
            var instance = arguments[1];
            //改变模态框内容
            template.addNodeModal($('.modal').find("#modal-form"));
            $('.modal').modal('toggle');
            $(".modal").find(".save").unbind();
            $(".modal").find(".save").bind("click", function () {
                var params = tool['serializeJson'].apply($('#modal-form'), arguments);
                if (!params.type || !params.node) {
                    alert("参数输入不完整.");
                    return;
                }
                _this.find(".jtk-surface-canvas").myJsPlumb("addNode",instance , params);
                $('.modal').modal('toggle');
            });
        }
    }

    var template = {
        addNodeModal: function (_this) {
            var text1 = tool.text01({"title": "名称", name: "node"});
            var radio1 = tool.radio01({"title": "起止框", value: "oval", name: "type"});
            var radio2 = tool.radio01({"title": "判断框", value: "rhombus", name: "type"});
            var radio3 = tool.radio01({"title": "执行框", value: "square", name: "type"});
            $(_this).html("");
            $(_this).append(text1).append(radio1).append(radio2).append(radio3);
        },
        processModal: function (_this) {
            var text1 = tool.text01({"title": "流程名称", name: "node"});
            var radio1 = tool.radio01({"title": "起止框", value: "oval", name: "type"});
            var radio2 = tool.radio01({"title": "判断框", value: "rhombus", name: "type"});
            var radio3 = tool.radio01({"title": "执行框", value: "square", name: "type"});
            $(_this).html("");
            $(_this).append(text1).append(radio1).append(radio2).append(radio3);
        },
        oval: function (title, code) {
            var div1 = $('<div style="left:0px;top:0px;width:100px;height:75px;" id="flowchart' + code + '"' +
                ' class="window flowchart-object flowchart-question jtk-node jtk-draggable jtk-droppable jtk-endpoint-anchor jtk-connected"' +
                ' data-jtk-node-id="question1"></div>');
            var div2 = $('<div style="position:relative"></div>');
            var svg = tool.svg("svg");
            $(svg).attr("version", "1.1")
                .attr("xmlns", "http://www.w3.org/1999/xhtml")
                .attr("width", "100").attr("height", "75")
                .attr("class", "process-step")
                .html('<ellipse version="1.1" xmlns="http://www.w3.org/1999/xhtml" cx="50" cy="35" rx="50" ry="35" class="outer"></ellipse>' +
                    '<ellipse version="1.1" xmlns="http://www.w3.org/1999/xhtml" cx="50" cy="35" rx="40" ry="25" class="inner"></ellipse>' +
                    '<text version="1.1" xmlns="http://www.w3.org/1999/xhtml" text-anchor="middle" x="50" y="35" dominant-baseline="central">' + title + '</text>');
            div2.append(svg);
            div1.append(div2);
            return div1;
        }, rhombus: function (title, code) {
            var div1 = $('<div style="left:0px;top:0px;width:150px;height:150px;" id="flowchart' + code + '"' +
                ' class="window flowchart-object flowchart-question jtk-node jtk-draggable jtk-droppable jtk-endpoint-anchor jtk-connected"' +
                ' data-jtk-node-id="question1"></div>');
            var div2 = $('<div style="position:relative"></div>');
            var svg = tool.svg("svg");
            $(svg).attr("version", "1.1")
                .attr("xmlns", "http://www.w3.org/1999/xhtml")
                .attr("width", "150").attr("height", "150")
                .attr("class", "process-step")
                .html('<path version="1.1" xmlns="http://www.w3.org/1999/xhtml" d="M 75 0 L 150 75 L 75 150 L 0 75 Z" class="outer"></path>' +
                    '<path version="1.1" xmlns="http://www.w3.org/1999/xhtml" d="M 75 10 L 140 75 L 75 140 L 10 75 Z" class="inner"></path>' +
                    '<text version="1.1" xmlns="http://www.w3.org/1999/xhtml" text-anchor="middle" x="75" y="75" dominant-baseline="central">' + title + '</text>');
            div2.append(svg);
            div1.append(div2);
            return div1;
        }, square: function (title, code) {
            var div1 = $('<div style="left:0px;top:0px;width:120px;height:120px;" id="flowchart' + code + '"' +
                ' class="window flowchart-object flowchart-question jtk-node jtk-draggable jtk-droppable jtk-endpoint-anchor jtk-connected"' +
                ' data-jtk-node-id="question1"></div>');
            var div2 = $('<div style="position:relative"></div>');
            var svg = tool.svg("svg");
            $(svg).attr("version", "1.1")
                .attr("xmlns", "http://www.w3.org/1999/xhtml")
                .attr("width", "120").attr("height", "120")
                .attr("class", "process-step")
                .html('<rect version="1.1" xmlns="http://www.w3.org/1999/xhtml" x="0" y="0" width="120" height="120" class="outer drag-start"></rect>' +
                    '<rect version="1.1" xmlns="http://www.w3.org/1999/xhtml" x="10" y="10" width="100" height="100" class="inner"></rect>' +
                    '<text version="1.1" xmlns="http://www.w3.org/1999/xhtml" text-anchor="middle" x="60" y="60" dominant-baseline="central">' + title + '</text>');
            div2.append(svg);
            div1.append(div2);
            return div1;
        }
    }

    $.fn.myJsPlumb = function () {
        var method = arguments[0];
        if (methods[method]) {
            method = methods[method];
            arguments = Array.prototype.slice.call(arguments, 1);
        } else if (typeof(method) == object || !method) {
            method = methods.init();
        } else {
            console.info("指定方法不存在.");
        }
        return method.apply(this, arguments);
    }
})(jQuery);