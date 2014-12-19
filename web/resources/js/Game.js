var letters;

function initColorInfor()
{
   letters = new Array();
   letters["A"] = "grayLetter";
   letters["B"] = "grayLetter";
   letters["C"] = "grayLetter";
   letters["D"] = "grayLetter";
   letters["E"] = "grayLetter";
   letters["F"] = "grayLetter";
   letters["G"] = "grayLetter";
   letters["H"] = "grayLetter";
   letters["I"] = "grayLetter";
   letters["J"] = "grayLetter";
   letters["K"] = "grayLetter";
   letters["L"] = "grayLetter";
   letters["M"] = "grayLetter";
   letters["N"] = "grayLetter";
   letters["O"] = "grayLetter";
   letters["P"] = "grayLetter";
   letters["Q"] = "grayLetter";
   letters["R"] = "grayLetter";
   letters["S"] = "grayLetter";
   letters["T"] = "grayLetter";
   letters["U"] = "grayLetter";
   letters["V"] = "grayLetter";
   letters["W"] = "grayLetter";
   letters["X"] = "grayLetter";
   letters["Y"] = "grayLetter";
   letters["Z"] = "grayLetter";
}

function changeLetterColor(spanToChange)
{
    if (spanToChange.className === "grayLetter")
    {
        spanToChange.className = "greenLetter";
        letters[spanToChange.innerHTML] = "greenLetter";
    }
    else if (spanToChange.className === "greenLetter")
    {
        spanToChange.className = "redLetter";
        letters[spanToChange.innerHTML] = "redLetter";
    }
    else
    {
        spanToChange.className = "grayLetter";
        letters[spanToChange.innerHTML] = "grayLetter";
    }
}



