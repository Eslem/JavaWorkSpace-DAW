/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function comprar(button) {
    var table = document.getElementById("table");
    if (table === null) {
        table = setUpTable();
    }
    var parent = button.parentNode;
    var nameStr = parent.getElementsByTagName("h3")[0].innerHTML;
    var row = document.getElementById(nameStr);
    if (row === null) {
        createRow(nameStr, table, parent);
    } else {
        more(row);
    }
}

function createRow(nameStr, table, parent) {
    var tr = document.createElement("tr");
    tr.id = nameStr;
    var name = document.createElement("td");

    name.appendChild(document.createTextNode(nameStr));
    var price = document.createElement("td");
    var priceStr = parent.getElementsByTagName("p")[0].innerHTML;
    price.appendChild(document.createTextNode(priceStr));

    var cantidad = document.createElement("td");
    cantidad.appendChild(document.createTextNode(1));

    //buttons
    var buttonsTd = document.createElement("td");
    var button1 = document.createElement("button");
    var icon1 = document.createElement("i");
    icon1.className = "fa fa-plus";
    button1.className = "bt sm default";
    button1.appendChild(icon1);
    buttonsTd.appendChild(button1);
    button1.onclick = function () {
        more(tr);
    };

    var button2 = document.createElement("button");
    var icon2 = document.createElement("i");
    icon2.className = "fa fa-minus";
    button2.className = "bt sm default";
    button2.appendChild(icon2);
    buttonsTd.appendChild(button2);
    button2.onclick = function () {
        minus(tr);
    };

    tr.appendChild(name);
    tr.appendChild(price);
    tr.appendChild(cantidad);
    tr.appendChild(buttonsTd);

    var totalRow = document.getElementById("totalRow");
    table.insertBefore(tr, totalRow);

    var total = document.getElementById("total");
    var totalInt = parseInt(total.innerHTML);

    total.innerHTML = totalInt + parseInt(priceStr);
}

function setUpTable() {
    var table = document.createElement("table");
    table.id = "table";
    table.className = "table striped bordered condensed centerDiv";
    var tr = document.createElement("tr");
    var names = ["Nombre", "Precio", "Cantidad"];

    for (var x = 0; x < names.length; x++) {
        var th = document.createElement("th");
        var text = document.createTextNode(names[x]);
        th.appendChild(text);
        tr.appendChild(th);
    }

    var clean = document.createElement("th");
    clean.innerHTML = "<button class='bt default sm' onclick='clean()'><i class='fa fa-trash-o'></i></button>";
    tr.appendChild(clean);

    table.appendChild(tr);
    document.body.appendChild(table);

    var totalRow = document.createElement("tr");
    totalRow.id = "totalRow";
    var totalTd = document.createElement("td");
    totalTd.className = "muted";
    totalTd.colSpan = 3;
    var totalStr = document.createElement("totalStr");
    totalStr.appendChild(document.createTextNode("Total= "));
    var total = document.createElement("span");
    total.appendChild(document.createTextNode("0"));
    total.id = "total";
    

    totalTd.appendChild(totalStr);
    totalTd.appendChild(total);
    totalRow.appendChild(totalTd);
    table.appendChild(totalRow);

    return table;

}


function more(row) {
    var tdCantidad = row.getElementsByTagName("td")[2];
    tdCantidad.innerHTML = parseInt(tdCantidad.innerHTML) + 1;
    var tdPrice = row.getElementsByTagName("td")[1];
    var priceStr = tdPrice.innerHTML;

    var total = document.getElementById("total");
    var totalInt = parseInt(total.innerHTML);
    total.innerHTML = totalInt + parseInt(priceStr);
}

function minus(row) {
    var cant = row.getElementsByTagName("td")[2].innerHTML;
    if (cant === "1") {
        row.parentElement.removeChild(row);
        checkTable();
    } else {
        var tdCantidad = row.getElementsByTagName("td")[2];
        tdCantidad.innerHTML = parseInt(tdCantidad.innerHTML) - 1;
        var tdPrice = row.getElementsByTagName("td")[1];
        var priceStr = tdPrice.innerHTML;

        var total = document.getElementById("total");
        var totalInt = parseInt(total.innerHTML);
        total.innerHTML = totalInt - parseInt(priceStr);
    }
}


function checkTable() {
    var table = document.getElementById("table");
    if (table.getElementsByTagName("tr").length === 2) {
        table.parentElement.removeChild(table);
    }
}

function clean() {
    var table = document.getElementById("table");
    table.parentElement.removeChild(table);

}