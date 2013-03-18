﻿<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>CapitalsQuiz</title>


    <link href="css/default.css" rel="stylesheet" />
    <link rel="stylesheet" href="bootstrap-buttons/css/bootstrap.css">
    <link rel="stylesheet" href="stately/css/stately.css">

    <!-- Microsoft Advertising required references -->

    <script src="js/capitals.js"></script>
</head>
<body onload="promptQuestion()">
    <h1>State Quiz</h1>

    <select id="type" onchange="promptQuestion()">
      <option value="0">Capitals</option>
      <option value="1">States</option>
      <option value="2">Abbreviations</option>
    </select>
    <br />
    <label id="prompt"></label>
    <br />
    <input id="answer" type="text" onkeydown="if (event.keyCode == 13) document.getElementById('enterButton').click()" />
    <!--<button id="enterButton" type="button" class="btn btn-info" onclick="evaluate()" >Enter</button>-->
    <input id="enterButton" type="button" class="btn btn-info" onclick="evaluate()" value="Enter" />
    <br />
    <label id="solution"></label>
    <br />
    <label id="counters"><span id="correct"></span> / <span id="total"></span></label>

    <div id="map">
      <ul class="stately">
        <li data-state="al" id="al">A</li> 
        <li data-state="ak" id="ak">B</li> 
        <li data-state="ar" id="ar">C</li> 
        <li data-state="az" id="az">D</li> 
        <li data-state="ca" id="ca">E</li> 
        <li data-state="co" id="co">F</li> 
        <li data-state="ct" id="ct">G</li> 
        <li data-state="de" id="de">H</li> 
        <li data-state="dc" id="dc">I</li> 
        <li data-state="fl" id="fl">J</li> 
        <li data-state="ga" id="ga">K</li> 
        <li data-state="hi" id="hi">L</li> 
        <li data-state="id" id="id">M</li> 
        <li data-state="il" id="il">N</li> 
        <li data-state="in" id="in">O</li> 
        <li data-state="ia" id="ia">P</li> 
        <li data-state="ks" id="ks">Q</li> 
        <li data-state="ky" id="ky">R</li> 
        <li data-state="la" id="la">S</li> 
        <li data-state="me" id="me">T</li> 
        <li data-state="md" id="md">U</li> 
        <li data-state="ma" id="ma">V</li> 
        <li data-state="mi" id="mi">W</li> 
        <li data-state="mn" id="mn">X</li> 
        <li data-state="ms" id="ms">Y</li> 
        <li data-state="mo" id="mo">Z</li> 
        <li data-state="mt" id="mt">a</li> 
        <li data-state="ne" id="ne">b</li> 
        <li data-state="nv" id="nv">c</li> 
        <li data-state="nh" id="nh">d</li> 
        <li data-state="nj" id="nj">e</li> 
        <li data-state="nm" id="nm">f</li> 
        <li data-state="ny" id="ny">g</li> 
        <li data-state="nc" id="nc">h</li> 
        <li data-state="nd" id="nd">i</li> 
        <li data-state="oh" id="oh">j</li> 
        <li data-state="ok" id="ok">k</li> 
        <li data-state="or" id="or">l</li> 
        <li data-state="pa" id="pa">m</li> 
        <li data-state="ri" id="ri">n</li> 
        <li data-state="sc" id="sc">o</li> 
        <li data-state="sd" id="sd">p</li> 
        <li data-state="tn" id="tn">q</li> 
        <li data-state="tx" id="tx">r</li> 
        <li data-state="ut" id="ut">s</li> 
        <li data-state="va" id="va">t</li> 
        <li data-state="vt" id="vt">u</li> 
        <li data-state="wa" id="wa">v</li> 
        <li data-state="wv" id="wv">w</li> 
        <li data-state="wi" id="wi">x</li> 
        <li data-state="wy" id="wy">y</li> 
      </ul>
    </div>
    <input id="hintButton" type="button" class="btn btn-danger" onclick="hintButton()" value="Hints Off" />

</body>
</html>
