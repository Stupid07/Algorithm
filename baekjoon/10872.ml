let rec factorial n number =
	if n > 0 then factorial (n-1) (number*n)
	else Printf.printf "%d" number;;

 Scanf.scanf " %d" (fun num -> factorial num 1);;