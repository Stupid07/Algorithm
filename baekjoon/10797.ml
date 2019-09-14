let rec carCount number day count =
	let nextCar = Scanf.scanf " %d" (fun n->n) in
	let nextCount = if nextCar=day then count+1 else count in
	if number > 1 then carCount (number-1) (day) (nextCount)
	else Printf.printf "%d" nextCount;;

Scanf.scanf " %d" (fun day-> carCount 5 day 0);;