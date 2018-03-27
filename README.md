<?php
	require "connect.php";
	// Buoc 1 : Tao ra cau truc cua json
	class Monanviet{
		function Monanviet($id,$ten,$gia,$hinhanh){
				$this->Id = $id;
				$this->Tenmonan = $ten;
				$this->Giamonan = $gia;
				$this->Hinhanh = $hinhanh;
		}
	}
	// Buoc 2 : Thuc hien cau truy van tra du lieu ve
	$query = "SELECT * FROM monanviet";
	$data = mysqli_query($con,$query);
	//Buoc 3 : Tao mang
	$mangmonan = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangmonan,new Monanviet($row['Id'],
										 	$row['Tenmonan']
										 	,$row['Giamonan']
										 	,$row['Hinhanh']));
	}
	// Buoc 4 : Tra ve json
	echo json_encode($mangmonan);
?>
