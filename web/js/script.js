function switchDisplay(element)
{
    alert("allo");
    x = document.getElementById(element).style;
    if (x.display == 'block')
        x.display = 'none';
    else
        x.display = 'block';
}
