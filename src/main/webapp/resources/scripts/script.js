document.addEventListener("DOMContentLoaded",function () {
    setRadius(2);
    canvas.addEventListener("click", mouseHandler);
    deleteButton.addEventListener('click',deleteDots);
    drawAllPointsFromResultTable();
    function mouseHandler(event) {
        if (currentRadius === null) {
            return;
        }
        const rect = canvas.getBoundingClientRect();
        mouse.x = event.clientX - rect.left;
        mouse.y = event.clientY - rect.top;
        return clickingProcessing(mouse.x, mouse.y);
    }
    function clickingProcessing(clicked_x, clicked_y) {
        let x = parseFloat((((clicked_x - w / 2) / hatchGap) / 2) * currentRadius).toFixed(3);
        let y = parseFloat((-((clicked_y - h / 2) / hatchGap) / 2) * currentRadius).toFixed(3);
        sendCoordinates(x, y);
        return {
            x: x,
            y: y,
        }
    }
});
let xVal = document.getElementById("clicking-form:xHidden");
let yVal = document.getElementById("clicking-form:clickingYHidden");
let sbButton = document.getElementById('clicking-form:click-submit');
let deleteButton = document.getElementById('deleteButton');
function deleteDots(){
    redrawGraph();
}
function sendCoordinates(xValue,yValue){
    xVal.value = xValue;
    yVal.value = yValue;
    sbButton.click();
}
function drawAllPointsFromResultTable(){
    let i = 0;
    while (true){
        let x = document.getElementById('results-table:' + i + ':xResult');
        if(x==null)
            break;
        let y = document.getElementById('results-table:'+ i + ':yResult');
        let result = document.getElementById('results-table:' + i + ':HitResult');
        let isHit = result.innerHTML === '✅';
        printDotOnGraph(x.innerHTML,y.innerHTML,isHit);
        i++;
    }
}
