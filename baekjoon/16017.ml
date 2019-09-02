let process = fun first second third fourth ->
	let digitCheck number = (number = 8 || number = 9) in
	if (digitCheck first) && (digitCheck fourth) && (second = third)
	then Printf.printf "ignore"
	else Printf.printf "answer";;

Scanf.scanf " %d %d %d %d" process;;