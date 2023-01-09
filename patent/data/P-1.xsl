<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:p1="http://www.foolstech.com/p1"
                version="2.0">
 <xsl:template match="/">
   <!--docxjs library predefined styles-->
   <style>
    .docx-wrapper {
    background: white;
    padding: 0px;
    padding-bottom: 0px;
    display: flex;
    flex-flow: column;
    align-items: center;
    }

    .docx-wrapper>section.docx {
    background: white;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    margin-bottom: 30px;
    }

    .docx {
    color: black;
    }

    section.docx {
    box-sizing: border-box;
    display: flex;
    flex-flow: column nowrap;
    position: relative;
    overflow: hidden;
    }

    section.docx>article {
    margin-bottom: auto;
    }

    .docx table {
    border-collapse: collapse;
    }

    .docx table td,
    .docx table th {
    vertical-align: top;
    }

    .docx p {
    margin: 0pt;
    min-height: 1em;
    }

    .docx span {
    white-space: pre-wrap;
    overflow-wrap: break-word;
    }

    .docx a {
    color: inherit;
    text-decoration: inherit;
    }
   </style><!--docxjs mathml polyfill styles-->
   <style>
    @namespace "http://www.w3.org/1998/Math/MathML";

    math {
    display: inline-block;
    line-height: initial;
    }

    mfrac {
    display: inline-block;
    vertical-align: -50%;
    text-align: center;
    }

    mfrac> :first-child {
    border-bottom: solid thin currentColor;
    }

    mfrac>* {
    display: block;
    }

    msub> :nth-child(2) {
    font-size: smaller;
    vertical-align: sub;
    }

    msup> :nth-child(2) {
    font-size: smaller;
    vertical-align: super;
    }

    munder,
    mover,
    munderover {
    display: inline-flex;
    flex-flow: column nowrap;
    vertical-align: middle;
    text-align: center;
    }

    munder> :not(:first-child),
    mover> :not(:first-child),
    munderover> :not(:first-child) {
    font-size: smaller;
    }

    munderover> :last-child {
    order: -1;
    }

    mroot,
    msqrt {
    position: relative;
    display: inline-block;
    border-top: solid thin currentColor;
    margin-top: 0.5px;
    vertical-align: middle;
    margin-left: 1ch;
    }

    mroot:before,
    msqrt:before {
    content: "";
    display: inline-block;
    position: absolute;
    width: 1ch;
    left: -1ch;
    top: -1px;
    bottom: 0;
    background-image: url("data:image/svg+xml,%3Csvg xmlns=%27http://www.w3.org/2000/svg%27 viewBox=%270 0 20 100%27 preserveAspectRatio=%27none%27%3E%3Cpath d=%27m0,75 l5,0 l5,25 l10,-100%27 stroke=%27black%27 fill=%27none%27 vector-effect=%27non-scaling-stroke%27/%3E%3C/svg%3E");
    }

    /*# sourceURL=webpack://./src/mathml.scss */
    /*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9tYXRobWwuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSwrQ0FBQTtBQUVBO0VBQ0kscUJBQUE7RUFDQSxvQkFBQTtBQUFKOztBQUdBO0VBQ0kscUJBQUE7RUFDQSxvQkFBQTtFQUNBLGtCQUFBO0FBQUo7QUFFSTtFQUNJLHNDQUFBO0FBQVI7QUFHSTtFQUNJLGNBQUE7QUFEUjs7QUFNSTtFQUNJLGtCQUFBO0VBQ0EsbUJBQUE7QUFIUjs7QUFRSTtFQUNJLGtCQUFBO0VBQ0EscUJBQUE7QUFMUjs7QUFTQTtFQUNJLG9CQUFBO0VBQ0Esd0JBQUE7RUFDQSxzQkFBQTtFQUNBLGtCQUFBO0FBTko7QUFRSTtFQUNJLGtCQUFBO0FBTlI7O0FBV0k7RUFBZ0IsU0FBQTtBQVBwQjs7QUFVQTtFQUNJLGtCQUFBO0VBQ0EscUJBQUE7RUFDQSxtQ0FBQTtFQUNBLGlCQUFBO0VBQ0Esc0JBQUE7RUFDQSxnQkFBQTtBQVBKO0FBU0k7RUFDSSxXQUFBO0VBQ0EscUJBQUE7RUFDQSxrQkFBQTtFQUNBLFVBQUE7RUFDQSxVQUFBO0VBQ0EsU0FBQTtFQUNBLFNBQUE7RUFDQSx5REFBQTtBQVBSIiwic291cmNlc0NvbnRlbnQiOlsiQG5hbWVzcGFjZSBcImh0dHA6Ly93d3cudzMub3JnLzE5OTgvTWF0aC9NYXRoTUxcIjtcclxuXHJcbm1hdGgge1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgbGluZS1oZWlnaHQ6IGluaXRpYWw7XHJcbn1cclxuXHJcbm1mcmFjIHtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICAgIHZlcnRpY2FsLWFsaWduOiAtNTAlO1xyXG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG5cclxuICAgICY+OmZpcnN0LWNoaWxkIHtcclxuICAgICAgICBib3JkZXItYm90dG9tOiBzb2xpZCB0aGluIGN1cnJlbnRDb2xvcjtcclxuICAgIH1cclxuXHJcbiAgICAmPioge1xyXG4gICAgICAgIGRpc3BsYXk6IGJsb2NrO1xyXG4gICAgfVxyXG59XHJcblxyXG5tc3ViIHtcclxuICAgICY+Om50aC1jaGlsZCgyKSB7XHJcbiAgICAgICAgZm9udC1zaXplOiBzbWFsbGVyO1xyXG4gICAgICAgIHZlcnRpY2FsLWFsaWduOiBzdWI7XHJcbiAgICB9XHJcbn1cclxuXHJcbm1zdXAge1xyXG4gICAgJj46bnRoLWNoaWxkKDIpIHtcclxuICAgICAgICBmb250LXNpemU6IHNtYWxsZXI7XHJcbiAgICAgICAgdmVydGljYWwtYWxpZ246IHN1cGVyO1xyXG4gICAgfVxyXG59XHJcblxyXG5tdW5kZXIsIG1vdmVyLCBtdW5kZXJvdmVyIHtcclxuICAgIGRpc3BsYXk6IGlubGluZS1mbGV4O1xyXG4gICAgZmxleC1mbG93OiBjb2x1bW4gbm93cmFwO1xyXG4gICAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcclxuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuXHJcbiAgICAmPjpub3QoOmZpcnN0LWNoaWxkKSB7XHJcbiAgICAgICAgZm9udC1zaXplOiBzbWFsbGVyO1xyXG4gICAgfVxyXG59XHJcblxyXG5tdW5kZXJvdmVyIHtcclxuICAgICY+Omxhc3QtY2hpbGQgeyBvcmRlcjogLTE7IH1cclxufVxyXG5cclxubXJvb3QsIG1zcXJ0IHtcclxuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICAgIGJvcmRlci10b3A6IHNvbGlkIHRoaW4gY3VycmVudENvbG9yOyAgXHJcbiAgICBtYXJnaW4tdG9wOiAwLjVweDtcclxuICAgIHZlcnRpY2FsLWFsaWduOiBtaWRkbGU7ICBcclxuICAgIG1hcmdpbi1sZWZ0OiAxY2g7IFxyXG5cclxuICAgICY6YmVmb3JlIHtcclxuICAgICAgICBjb250ZW50OiBcIlwiO1xyXG4gICAgICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICAgICAgICBwb3NpdGlvbjogYWJzb2x1dGU7XHJcbiAgICAgICAgd2lkdGg6IDFjaDtcclxuICAgICAgICBsZWZ0OiAtMWNoO1xyXG4gICAgICAgIHRvcDogLTFweDtcclxuICAgICAgICBib3R0b206IDA7XHJcbiAgICAgICAgYmFja2dyb3VuZC1pbWFnZTogdXJsKFwiZGF0YTppbWFnZS9zdmcreG1sLCUzQ3N2ZyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnIHZpZXdCb3g9JzAgMCAyMCAxMDAnIHByZXNlcnZlQXNwZWN0UmF0aW89J25vbmUnJTNFJTNDcGF0aCBkPSdtMCw3NSBsNSwwIGw1LDI1IGwxMCwtMTAwJyBzdHJva2U9J2JsYWNrJyBmaWxsPSdub25lJyB2ZWN0b3ItZWZmZWN0PSdub24tc2NhbGluZy1zdHJva2UnLyUzRSUzQy9zdmclM0VcIik7XHJcbiAgICB9XHJcbn0iXSwic291cmNlUm9vdCI6IiJ9 */
   </style><!--docxjs document theme values-->
   <style>
    .docx {
    --docx-majorHAnsi-font: Calibri Light;
    --docx-minorHAnsi-font: Calibri;
    --docx-dk1-color: #000000;
    --docx-lt1-color: #FFFFFF;
    --docx-dk2-color: #44546A;
    --docx-lt2-color: #E7E6E6;
    --docx-accent1-color: #5B9BD5;
    --docx-accent2-color: #ED7D31;
    --docx-accent3-color: #A5A5A5;
    --docx-accent4-color: #FFC000;
    --docx-accent5-color: #4472C4;
    --docx-accent6-color: #70AD47;
    --docx-hlink-color: #0563C1;
    --docx-folHlink-color: #954F72;
    }
   </style><!--docxjs document styles-->
   <style>
    .docx span {
    font-family: Times New Roman;
    }

    .docx p,
    p.docx_1 {
    margin-bottom: 0.15pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    .docx p,
    p.docx_1 span {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    p.docx_2 {
    margin-top: 24.00pt;
    margin-bottom: 6.00pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_2 span {
    font-weight: bold;
    min-height: 24.00pt;
    font-size: 24.00pt;
    font-family: Arial;
    color: #000000;
    }

    p.docx_3 {
    margin-top: 18.00pt;
    margin-bottom: 4.00pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_3 span {
    font-weight: bold;
    min-height: 18.00pt;
    font-size: 18.00pt;
    font-family: Arial;
    color: #000000;
    }

    p.docx_4 {
    margin-top: 14.00pt;
    margin-bottom: 4.00pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_4 span {
    font-weight: bold;
    min-height: 14.00pt;
    font-size: 14.00pt;
    font-family: Arial;
    color: #000000;
    }

    p.docx_5 {
    margin-top: 12.00pt;
    margin-bottom: 2.00pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_5 span {
    font-weight: bold;
    min-height: 12.00pt;
    font-size: 12.00pt;
    font-family: Arial;
    color: #000000;
    }

    p.docx_6 {
    margin-top: 11.00pt;
    margin-bottom: 2.00pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_6 span {
    font-weight: bold;
    min-height: 11.00pt;
    font-size: 11.00pt;
    font-family: Arial;
    color: #000000;
    }

    p.docx_7 {
    margin-top: 10.00pt;
    margin-bottom: 2.00pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_7 span {
    font-weight: bold;
    min-height: 10.00pt;
    font-size: 10.00pt;
    font-family: Arial;
    color: #000000;
    }

    .docx table,
    table.docx_9 td {
    padding-top: 0.00pt;
    padding-left: 5.40pt;
    padding-bottom: 0.00pt;
    padding-right: 5.40pt;
    }

    p.docx_10 {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_10 span {
    font-family: Tahoma;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    p.docx_10 span {
    font-family: Tahoma;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    span.docx_11 {
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    p.docx_12 {
    line-height: 1.00;
    margin-bottom: 0.15pt;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_12 span {
    min-height: 10.00pt;
    font-size: 10.00pt;
    font-family: Arial;
    color: #000000;
    }

    p.docx_12 span {
    font-family: Arial;
    color: #000000;
    min-height: 10.00pt;
    font-size: 10.00pt;
    }

    p.docx_13 span {
    font-weight: bold;
    min-height: 10.00pt;
    font-size: 10.00pt;
    font-family: Arial;
    color: #000000;
    }

    p.docx_13 {
    line-height: 1.00;
    margin-bottom: 0.15pt;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_13 span {
    font-family: Arial;
    font-weight: bold;
    color: #000000;
    min-height: 10.00pt;
    font-size: 10.00pt;
    }

    p.docx_14 {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_14 span {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    p.docx_14 span {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    p.docx_15 {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_15 span {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    p.docx_15 span {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    p.docx_16 {
    margin-top: 18.00pt;
    margin-bottom: 4.00pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_16 span {
    font-family: Georgia;
    font-style: italic;
    color: #666666;
    min-height: 24.00pt;
    font-size: 24.00pt;
    }

    table.docx_17 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_17 td {
    border-top: 0.50pt solid black;
    border-left: 0.50pt solid black;
    border-bottom: 0.50pt solid black;
    border-right: 0.50pt solid black;
    }

    p.docx_19 {
    margin-top: 24.00pt;
    margin-bottom: 6.00pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    p.docx_19 span {
    font-weight: bold;
    min-height: 36.00pt;
    font-size: 36.00pt;
    font-family: Arial;
    color: #000000;
    }

    table.docx_20 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_20 td {
    padding-top: 0.00pt;
    padding-left: 0.00pt;
    padding-bottom: 0.00pt;
    padding-right: 0.00pt;
    }

    span.docx_21 {
    font-family: Tahoma;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    span.docx_21 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    span.docx_21 {
    font-family: Tahoma;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    p.docx_22 {
    margin-left: 36.00pt;
    margin-bottom: 0.15pt;
    line-height: 1.08;
    text-indent: -0.50pt;
    }

    p.docx_22 span {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    span.docx_23 {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    span.docx_23 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    span.docx_23 {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    table.docx_24 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_24 td {
    padding-top: 0.00pt;
    padding-left: 0.00pt;
    padding-bottom: 0.00pt;
    padding-right: 0.00pt;
    }

    table.docx_25 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_25 span {}

    table.docx_25 td {
    border-top: 0.50pt solid black;
    border-left: 0.50pt solid black;
    border-bottom: 0.50pt solid black;
    border-right: 0.50pt solid black;
    }

    span.docx_26 {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    span.docx_26 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    span.docx_26 {
    font-family: Arial;
    color: #000000;
    min-height: 8.00pt;
    font-size: 8.00pt;
    }

    table.docx_27 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_27 td {
    padding-top: 0.00pt;
    padding-left: 0.00pt;
    padding-bottom: 0.00pt;
    padding-right: 0.00pt;
    }

    table.docx_28 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_28 td {
    padding-top: 0.00pt;
    padding-left: 0.00pt;
    padding-bottom: 0.00pt;
    padding-right: 0.00pt;
    }

    span.docx_29 {
    font-family: Arial;
    color: #000000;
    min-height: 10.00pt;
    font-size: 10.00pt;
    }

    span.docx_29 p {
    line-height: 1.00;
    margin-bottom: 0.15pt;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    span.docx_29 {
    min-height: 10.00pt;
    font-size: 10.00pt;
    font-family: Arial;
    color: #000000;
    }

    span.docx_30 {
    font-family: Arial;
    font-weight: bold;
    color: #000000;
    min-height: 10.00pt;
    font-size: 10.00pt;
    }

    span.docx_30 {
    font-weight: bold;
    min-height: 10.00pt;
    font-size: 10.00pt;
    font-family: Arial;
    color: #000000;
    }

    span.docx_30 p {
    line-height: 1.00;
    margin-bottom: 0.15pt;
    text-indent: -0.50pt;
    margin-left: 0.50pt;
    }

    span.docx_31 {
    color: #808080;
    }

    table.docx_32 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_32 td {
    padding-top: 0.00pt;
    padding-left: 7.10pt;
    padding-bottom: 0.00pt;
    padding-right: 5.75pt;
    }

    table.docx_33 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_33 td {
    padding-top: 6.60pt;
    padding-left: 5.40pt;
    padding-bottom: 5.20pt;
    padding-right: 5.75pt;
    }

    table.docx_34 p {
    margin-bottom: 0.00pt;
    line-height: 1.00;
    }

    table.docx_34 td {
    padding-top: 6.60pt;
    padding-left: 5.40pt;
    padding-bottom: 5.20pt;
    padding-right: 5.75pt;
    }
   </style>
   <div class="docx-wrapper">
    <section class="docx"
             style="padding: 0px; width: 595pt; min-height: 842pt; column-count: 1; column-gap: 36pt;">
     <header>
      <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; margin-right: 0.35pt; text-align: right;">
       <span>Образац П-1</span></p>
      <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; margin-right: 0.35pt; text-align: right;"/>
      <p style="margin-bottom: 0pt; text-indent: 0pt; margin-left: 0pt; margin-right: 0.35pt; text-align: right;"/>
     </header>
     <article>
      <p
              style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
      </p>
      <table class="docx_32" style="width: 322.75pt; table-layout: auto;">
       <colgroup>
        <col style="width: 66.75pt;"/>
        <col style="width: 81pt;"/>
        <col style="width: 135pt;"/>
        <col style="width: 40pt;"/>
       </colgroup>

       <tr style="height: 19.05pt;">
        <td
                style="border-bottom: none; border-right: none; vertical-align: middle; border-left: 1.5pt solid rgb(0, 0, 0); border-top: 1.5pt solid rgb(0, 0, 0); padding: 0pt 5.75pt 0pt 7.1pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Број пријаве</span></p>
        </td>
        <td rowspan="2" colspan="2"
            style="border-left: none; border-right: none; vertical-align: middle; border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); padding: 0pt 5.75pt 0pt 7.1pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 16pt; font-size: 16pt;">П</span><span
                 style="min-height: 16pt; font-size: 16pt;">-<xsl:value-of select="//@broj_prijave"/></span></p>
        </td>
        <td
                style="border-left: none; border-bottom: none; vertical-align: middle; border-right: 1.5pt solid rgb(0, 0, 0); border-top: 1.5pt solid rgb(0, 0, 0); padding: 0pt 5.75pt 0pt 7.1pt;">

        </td>
       </tr>
       <tr style="height: 4.55pt;">
        <td
                style="border-top: none; border-right: none; vertical-align: middle; border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); padding: 0pt 5.75pt 0pt 7.1pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span> </span></p>
        </td>
        <td colspan="2"
            style="display: none; border-left: none; border-right: none; vertical-align: middle; border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); padding: 0pt 5.75pt 0pt 7.1pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td
                style="border-top: none; border-left: none; vertical-align: middle; border-right: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); padding: 0pt 5.75pt 0pt 7.1pt;">
         <p style="margin-bottom: 8pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"/>
        </td>
       </tr>
       <tr style="height: 19.35pt;">
        <td colspan="2"
            style="border-top: 1.5pt solid rgb(0, 0, 0); border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: none; border-right: 1.5pt solid rgb(0, 0, 0); background-color: inherit; vertical-align: middle; padding: 0pt 5.75pt 0pt 7.1pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Датум пријема</span></p>
        </td>
        <td
                style="border-top: 1.5pt solid rgb(0, 0, 0); border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: none; border-right: none; background-color: inherit; vertical-align: middle; padding: 0pt 5.75pt 0pt 7.1pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Признати датум подношења</span></p>
        </td>
        <td
                style="border-top: 1.5pt solid rgb(0, 0, 0); border-left: none; border-bottom: none; border-right: 1.5pt solid rgb(0, 0, 0); background-color: inherit; vertical-align: middle; padding: 0pt 5.75pt 0pt 7.1pt;">

        </td>
       </tr>
       <tr style="height: 19.35pt;">
        <td colspan="2"
            style="border-top: none; border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); vertical-align: middle; padding: 0pt 5.75pt 0pt 7.1pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//@datum_prijema"/></span></p>
        </td>
        <td colspan="2"
            style="border-top: none; border-left: 1.5pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); vertical-align: middle; padding: 0pt 5.75pt 0pt 7.1pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//@datum_podnosenja"/></span></p>
        </td>
       </tr>

      </table>
      <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;"><span
              style="min-height: 10pt; font-size: 10pt;"> Република Србија</span></p>
      <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;"><span
              style="min-height: 10pt; font-size: 10pt;"> Завод за интелектуалну својину</span></p>
      <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;"><span
              style="min-height: 10pt; font-size: 10pt;"> Кнегиње Љубице број 5</span></p>
      <p style="margin-bottom: 0pt;"><span style="min-height: 10pt; font-size: 10pt;"> 11000 Београд</span></p>
      <p style="margin-bottom: 0pt; text-indent: -0.55pt; margin-left: 0.55pt;"/>
      <p style="margin-bottom: 0.25pt; text-align: center;"><span
              style="font-weight: bold; min-height: 12pt; font-size: 12pt;">ЗАХТЕВ</span></p>
      <p style="margin-bottom: 0.25pt; text-align: center;"><span
              style="font-weight: bold; min-height: 12pt; font-size: 12pt;">ЗА ПРИЗНАЊЕ ПАТЕНТА</span></p>
      <p style="margin-bottom: 0.25pt; text-indent: 0pt; margin-left: 0pt;"/>
      <p style="margin-bottom: 0.25pt; text-indent: 0pt; margin-left: 0pt;"/>
      <p style="margin-bottom: 0.25pt; text-indent: 0pt; margin-left: 0pt; text-align: center;"/>
      <p style="margin-bottom: 0.25pt; text-indent: 0pt; margin-left: 0pt; text-align: center;"/>
      <table class="docx_33" style="width: 529.9pt; table-layout: auto;">
       <colgroup>
        <col style="width: 185.1pt;"/>
        <col style="width: 38.25pt;"/>
        <col style="width: 146.85pt;"/>
        <col style="width: 114.35pt;"/>
        <col style="width: 45.35pt;"/>
       </colgroup>
       <tr style="height: 1pt;">
        <td colspan="5"
            style="border-width: 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Поље број I</span><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;"> НАЗИВ ПРОНАЛАСКА</span></p>

        </td>
       </tr>
       <tr style="height: 14.95pt;">
        <td colspan="5"
            style="border-width: 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span style="min-height: 9pt; font-size: 9pt;">На српском језику:
         </span><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//naziv_na_srpskom"/></span></p>
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"/>
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span style="min-height: 9pt; font-size: 9pt;">На енглеском језику: </span><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//naziv_na_engleskom"/></span></p>
        </td>
       </tr>
       <tr style="height: 1pt;">
        <td colspan="4"
            style="border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Поље број II</span><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;"> ПОДНОСИЛАЦ ПРИЈАВЕ</span>
          <xsl:choose>
           <xsl:when test="//@je_pronalazac = 'true'"><span style="min-height: 9pt; font-size: 9pt;"> Подносилац пријаве је и проналазач</span></xsl:when>
           <xsl:otherwise><span style="min-height: 9pt; font-size: 9pt;"> Подносилац пријаве није проналазач</span></xsl:otherwise>
          </xsl:choose>


          <span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"> </span></p>
        </td>
        <td
                style="border-top: 1.5pt solid rgb(0, 0, 0); border-left: none; border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">

        </td>
       </tr>
       <tr style="height: 39.7pt;">
        <td rowspan="3"
            style="border-width: 0.75pt 0.75pt 1pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Име и презиме / Пословно име: </span></p>

         <p style="line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//podnosilac/ime"/></span></p>
        </td>
        <td rowspan="3" colspan="2"
            style="border-width: 0.75pt 0.75pt 1pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 0pt; margin-right: 1.15pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Улица и број, поштански број, место и држава:</span></p>
         <p style="line-height: 1;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//podnosilac/adresa/ulica"/></span>
         </p>
         <p style="line-height: 1;"><span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//podnosilac/adresa/postanski_broj"/></span></p>
         <p style="line-height: 1;"><span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//podnosilac/adresa/mesto"/></span></p>
         <p style="line-height: 1;"><span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//podnosilac/adresa/drzava"/></span></p>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Број телефона:</span></p>
         <p style="line-height: 1;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//podnosilac/kontakt/broj_telefona"/></span></p>
        </td>
       </tr>
       <tr style="height: 39.1pt;">
        <td
                style="display: none; border-width: 0.75pt 0.75pt 1pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="display: none; border-width: 0.75pt 0.75pt 1pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Број факса:</span></p>
         <p style="line-height: 1;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//podnosilac/kontakt/broj_faksa"/></span></p>
        </td>
       </tr>
       <tr style="height: 10.35pt;">
        <td
                style="display: none; border-width: 0.75pt 0.75pt 1pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="display: none; border-width: 0.75pt 0.75pt 1pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td rowspan="2" colspan="2"
            style="border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1.08; text-indent: -0.55pt; margin-left: 0.55pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Е-пошта:</span></p>
         <p style="line-height: 1;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="podnosilac/kontakt/e_posta"/></span></p>
        </td>
       </tr>
       <tr style="height: 19.3pt;">
        <td colspan="4"
            style="border-top: 0.75pt solid rgb(0, 0, 0); border-bottom: none; border-right: none; border-left: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Држављанство: </span><span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//podnosilac/@drzavljanstvo"/></span></p>
        </td>
        <td colspan="2"
            style="display: none; border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
       </tr>
       <tr style="height: 1pt;">
        <td colspan="5"
            style="border-width: 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); vertical-align: middle; padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1.08; text-indent: 0pt; margin-left: 0pt;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Поље број III ПРОНАЛАЗАЧ </span></p>
         
         <xsl:choose>
          <xsl:when test="//@ne_zeli_da_bude_naveden">
           <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                   style="min-height: 9pt; font-size: 9pt;"> </span><span
                   style="font-family: &quot;MS Gothic&quot;; min-height: 9pt; font-size: 9pt;"> </span><span
                   style="min-height: 9pt; font-size: 9pt;"> </span><span
                   style="font-family: &quot;MS Gothic&quot;; min-height: 10pt; font-size: 10pt;">☐</span><span
                   style="min-height: 9pt; font-size: 9pt;"> Проналазач не жели да буде наведен у пријави</span></p>
          </xsl:when>
          <xsl:otherwise> </xsl:otherwise>
         </xsl:choose>
         
        </td>
       </tr>
       <tr style="height: 15.4pt;">
        <td rowspan="3"
            style="border-width: 0.75pt 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Име и презиме: </span></p>
         <p style="line-height: 1;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//pronalazac/ime"/></span></p>
        </td>
        <td rowspan="3" colspan="2"
            style="border-width: 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Улица и број, поштански број, место и држава:</span></p>
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//pronalazac/adresa/ulica"/></span></p>
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                  select="//pronalazac/adresa/postanski_broj"/></span></p>
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                  select="//pronalazac/adresa/mesto"/></span></p>
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.25pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                  select="//pronalazac/adresa/drzava"/></span></p>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: -0.55pt; margin-left: 0.55pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Број телефона:</span></p>
         <p style="line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//pronalazac/kontakt/broj_telefona"/></span></p>
        </td>
       </tr>
       <tr style="height: 23.25pt;">
        <td
                style="display: none; border-width: 0.75pt 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="display: none; border-width: 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: -0.7pt; margin-left: 0pt; margin-right: 1.45pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Број факса:</span></p>
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: -0.7pt; margin-left: 0pt; margin-right: 1.45pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//pronalazac/kontakt/broj_faksa"/></span></p>
        </td>
       </tr>
       <tr style="height: 23.25pt;">
        <td
                style="display: none; border-width: 0.75pt 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="display: none; border-width: 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 0pt; margin-right: 1.45pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Е-пошта:</span></p>
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 0pt; margin-right: 1.45pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//pronalazac/kontakt/e_posta"/></span></p>
        </td>
       </tr>
      </table>
      <table class="docx_34" style="width: 529.8pt; table-layout: auto;">
       <colgroup>
        <col style="width: 19.05pt;"/>
        <col style="width: 116.6pt;"/>
        <col style="width: 116.6pt;"/>
        <col style="width: 10.95pt;"/>
        <col style="width: 118.1pt;"/>
        <col style="width: 21.6pt;"/>
        <col style="width: 90pt;"/>
        <col style="width: 36.8pt;"/>
       </colgroup>
       <tr style="height: 1pt;">
        <td colspan="8"
            style="border-width: 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1.08; text-indent: 0pt; margin-left: 0pt;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Поље број IV </span>
          <xsl:choose>
           <xsl:when test="//@vrsta_punomocnika = 'zastupanje'"><span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"> ПУНОМОЋНИК ЗА ЗАСТУПАЊЕ </span></xsl:when>
           <xsl:otherwise><span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"> ПУНОМОЋНИК ЗА ПРИЈЕМ ПИСМЕНА </span></xsl:otherwise>
          </xsl:choose>
          </p>
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;">
          <xsl:choose>
           <xsl:when test="//@je_zajednicki_predstavnik = 'true'"><span style="font-weight: bold; min-height: 9pt; font-size: 9pt;">ЗАЈЕДНИЧКИ ПРЕДСТАВНИК</span></xsl:when>
          </xsl:choose>
         </p>
        </td>
       </tr>
       <tr style="height: 31.2pt;">
        <td rowspan="2" colspan="4"
            style="border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Име и презиме / Пословно име</span><span style="min-height: 9pt; font-size: 9pt;"> </span></p>
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//punomocnik/ime"/></span></p>
        </td>
        <td rowspan="2" colspan="2"
            style="border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: 0pt; margin-left: 1.7pt; margin-right: 1.15pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Улица и број, поштански број и место:</span></p>
         <p style="line-height: 1;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//punomocnik/adresa/ulica"/></span>
         </p>
         <p style="line-height: 1;"><span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//punomocnik/adresa/postanski_broj"/></span></p>
         <p style="line-height: 1;"><span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//punomocnik/adresa/mesto"/></span></p>
         <p style="line-height: 1;"><span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//punomocnik/adresa/drzava"/></span></p>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 2pt; line-height: 1; text-indent: -0.55pt; margin-left: 0.55pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Број телефона:</span></p>
         <p style="line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="punomocnik/kontakt/broj_telefona"/></span></p>
        </td>
       </tr>
       <tr style="height: 8.2pt;">
        <td colspan="4"
            style="display: none; border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="display: none; border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt 1.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="line-height: 1;"><span style="min-height: 9pt; font-size: 9pt;">Е-пошта:</span></p>
         <p style="line-height: 1;"><span
                 style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="punomocnik/kontakt/e_posta"/></span></p>
        </td>
       </tr>
       <tr style="height: 1pt;">
        <td colspan="8"
            style="border-width: 1.5pt 1.5pt 0.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Поље број V АДРЕСА ЗА ДОСТАВЉАЊЕ </span></p>
        </td>
       </tr>
       <tr style="height: 17pt;">
        <td colspan="8"
            style="border-width: 0.5pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="min-height: 9pt; font-size: 9pt;">Улица и број, поштански број и место: </span><span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of
                 select="//adresa_za_dostavljanje/ulica"/>, <xsl:value-of
                 select="//adresa_za_dostavljanje/postanski_broj"/>, <xsl:value-of
                 select="//adresa_za_dostavljanje/mesto"/>, <xsl:value-of
                 select="//adresa_za_dostavljanje/drzava"/></span></p>
        </td>
       </tr>
       <tr style="height: 1pt;">
        <td colspan="8"
            style="border-width: 0.5pt 1.5pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Поље број VI НАЧИН ДОСТАВЉАЊА</span></p>
        </td>
       </tr>
       <tr style="height: 45.35pt;">
        <td colspan="8"
            style="border-width: 0.75pt 1.5pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p>
          <xsl:choose>
           <xsl:when test="//saglasnost_za_dostavljanje_u_elektronskoj_formi = 'true'"><span style="min-height: 9pt; font-size: 9pt;">Подносилац пријаве је сагласан да Завод врши достављање писмена електронским путем у форми електронског документа </span></xsl:when>
           <xsl:otherwise><span style="min-height: 9pt; font-size: 9pt;">Подносилац пријаве није сагласан да Завод врши достављање писмена електронским путем у форми електронског документа </span></xsl:otherwise>
          </xsl:choose>

         </p>
         <p>
          <xsl:choose>
           <xsl:when test="//saglasnost_za_dostavljanje_u_papirnoj_formi = 'true'"><span style="min-height: 9pt; font-size: 9pt;">Подносилац пријаве је сагласан да Завод врши достављање писмена у папирној форми </span></xsl:when>
           <xsl:otherwise><span style="min-height: 9pt; font-size: 9pt;">Подносилац пријаве није сагласан да Завод врши достављање писмена у папирној форми </span></xsl:otherwise>
          </xsl:choose>
         </p>

        </td>
       </tr>
       <tr style="height: 1pt;">
        <td colspan="7"
            style="border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Поље број VII</span>
          <xsl:choose>
           <xsl:when test="//vrsta_prijave = 'dopunska'"><span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"> ДОПУНСКА ПРИЈАВА </span></xsl:when>
           <xsl:otherwise><span style="font-weight: bold; min-height: 9pt; font-size: 9pt;"> ИЗДВОЈЕНА ПРИЈАВА</span></xsl:otherwise>
          </xsl:choose>
          
         </p>
        </td>
        <td
                style="border-top: 1.5pt solid rgb(0, 0, 0); border-left: none; border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
        </td>
       </tr>
       <tr style="height: 7.4pt;">
        <td colspan="7"
            style="border-top: 0.75pt solid rgb(0, 0, 0); border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Број првобитне пријаве / основне пријаве, односно основног патента: </span>
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//broj_prvobitne_prijave"/></span></p>
        </td>
        <td style="border-top: 0.75pt solid rgb(0, 0, 0); border-left: none; border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"/>
        </td>
       </tr>
       <tr style="height: 7.4pt;">
        <td colspan="7"
            style="border-top: 0.75pt solid rgb(0, 0, 0); border-bottom: 1.5pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;">
          <span style="min-height: 9pt; font-size: 9pt;">Датум подношења првобитнe пријаве / основне пријаве: </span>
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//datum_podnosenja_prvobitne_prijave"/></span></p>
        </td>
        <td
                style="border-top: 0.75pt solid rgb(0, 0, 0); border-left: none; border-bottom: 1.5pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"/>
        </td>
       </tr>
       <tr style="height: 1pt;">
        <td colspan="7"
            style="border-top: 1.5pt solid rgb(0, 0, 0); border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: none; border-left: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;">Поље број VIII ЗАХТЕВ ЗА ПРИЗНАЊЕ ПРАВА
          ПРВЕНСТВА ИЗ РАНИЈИХ ПРИЈАВА: </span></p>
        </td>
        <td
                style="border-top: 1.5pt solid rgb(0, 0, 0); border-left: none; border-bottom: 0.75pt solid rgb(0, 0, 0); border-right: 1.5pt solid rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
        </td>
       </tr>
       <tr style="height: 28.35pt;">
        <td colspan="2"
            style="border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt; text-align: center;"><span
                 style="min-height: 9pt; font-size: 9pt;">Датум подношења раније пријаве</span></p>
        </td>
        <td
                style="border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p
                 style="border-width: 0pt; border-style: solid; border-color: black; background-color: inherit; margin: 0pt; line-height: 1.15; text-indent: 0pt; text-align: left;">
         </p>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt; text-align: center;"><span
                 style="min-height: 9pt; font-size: 9pt;">Број раније пријаве </span></p>
        </td>
        <td colspan="3"
            style="border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt; text-align: center;"><span
                 style="min-height: 9pt; font-size: 9pt;">Двословна ознака државе, регионалне или међународне
          организације</span></p>
        </td>
       </tr>
       <xsl:for-each select="//zahtevi_za_priznanje_prvenstva_iz_ranijih_prijava/zahtev">
        <tr style="height: 17pt;">
        <td
                style="border-width: 0.75pt 0.75pt 0.75pt 1.5pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt; text-align: center;"><span
                 style="font-weight: bold; min-height: 9pt; font-size: 9pt;"><xsl:value-of select="position()"/>.</span></p>
        </td>
        <td
                style="border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//datum_podnosenje_ranije_prijave"/></span></p>
        </td>
        <td
                style="border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;"/>
        </td>
        <td colspan="2"
            style="border-width: 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//broj_ranije_prijave"/></span></p>
        </td>
        <td colspan="3"
            style="border-width: 0.75pt 1.5pt 0.75pt 0.75pt; border-style: solid; border-color: rgb(0, 0, 0); padding: 6.6pt 5.75pt 5.2pt 5.4pt;">
         <p style="margin-bottom: 0pt; line-height: 1; text-indent: 0pt; margin-left: 0pt;">
          <span style="min-height: 9pt; font-size: 9pt;"><xsl:value-of select="//dvoslovna_oznaka_drzave_ili_organizacije"/></span></p>
        </td>
       </tr>
       </xsl:for-each>
      </table>
      <p style="margin-bottom: 8pt; text-indent: 0pt; margin-left: 0pt;"/>
     </article>
     <footer>
      <p style="margin-bottom: 8pt; text-indent: 0pt; margin-left: 0pt;"/>
     </footer>
    </section>
   </div>
 </xsl:template>
</xsl:stylesheet>