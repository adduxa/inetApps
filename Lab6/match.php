<?php
/**
 * Университет ИТМО
 * Кафедра вычислительной техники
 * Программирование интернет-приложений
 *
 * Лабораторная работа №6
 * Знакомство с HTML, CSS и PHP
 * Вариант: 1003
 *
 * Выполнил:
 * студент II курса факультета ПИиКТ
 * Дьяков Андрей Александрович, группа P3200
 *
 * Преподаватель:
 * Гаврилов Антон Валерьевич
 *
 * Санкт-Петербург, 2016г.
 */

$start_time = microtime(true);

if(!(
	isset($_GET['x'], $_GET['y'], $_GET['r'])
	&& is_intstr($_GET['x']) && is_numeric($_GET['y']) && is_intstr($_GET['r'])
	&& $_GET['x'] >= -4 && $_GET['x'] <= 4
	&& $_GET['y'] >= -5 && $_GET['y'] <= 5
	&& $_GET['r'] >= 1 && $_GET['r'] <= 5
)) {
	die("Invalid input");
}
$x=floatval($_GET['x']);
$y=floatval($_GET['y']);
$r=floatval($_GET['r']);

$form = new Form($r);
$contains = $form->contains($x, $y);
?>
<!DOCTYPE html>
<html>
<head>
	<title>Lab6</title>
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<table border="1">
	<tr><th>X<th>Y<th>R
	<?php printf('<tr><td>%d<td>%.2f<td>%d', $x, $y, $r); ?>
	</table>
	<br>
	<span class="field">Matched: <span><?php echo $contains ? 'yes' : 'no'; ?></span></span>
	<br><br>
	<span class="field">Date: <span><?php echo date('d.m.Y H:i:s'); ?></span></span>
	<br>
	<span class="field">Time: <span><?php echo microtime(true) - $start_time; ?></span> sec</span>
</body>
</html>
<?php
function is_intstr($str) {
	return $str !== (int)$str;
}

class Form {
	private $lowerLimit;
    private $upperLimit;
    private $R;

    function __construct($r) {
        $this->R = $r;
        $this->lowerLimit = -$this->R;
        $this->upperLimit = $this->R;
    }

    function contains($x, $y) {
        return $x >= $this->lowerLimit && $x <= $this->upperLimit && $y <= $this->upper($x) && $y >= $this->lower($x);
    }

    function upper($x) {
        if ($x >= -$this->R/2 && $x <= 0) {
            return $this->R;
        } else {
            return 0;
        }
    }
    function lower($x) {
        if ($x <= 0) {
            return -$x/2 - $this->R/2;
        } else {
            return -sqrt(pow($this->R, 2) - pow($x, 2));
        }
    }

    function getLowerLimit() {
        return $this->lowerLimit;
    }

    function getUpperLimit() {
        return $this->upperLimit;
    }

    function getR() {
        return $this->R;
    }
}
?>