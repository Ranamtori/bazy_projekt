<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $zdjecie = $_FILES["zdjecie"]["tmp_name"];
  $nazwa = $_FILES["zdjecie"]["name"];

  // Sprawdzenie, czy przesłany plik jest obrazem
  $typyDozwolone = array("image/jpg", "image/png");
  if (!in_array($_FILES["zdjecie"]["type"], $typyDozwolone)) {
    echo "Nieprawidłowy format pliku. Akceptowane formaty to JPEG i PNG.";
    return;
  }

  // Ustawienie ścieżki zapisu na serwerze
  $sciezkaZapisu = "/src/corgi.jpg" . $corgi;

  // Przeniesienie przesłanego pliku na docelowe miejsce
  if (!move_uploaded_file($zdjecie, $sciezkaZapisu)) {
    echo "Wystąpił błąd podczas zapisywania pliku.";
    return;
  }

  // Tutaj dodaj logikę zapisu ścieżki do bazy danych lub innej operacji na danych

  echo "Zdjęcie zostało zapisane.";
}
?>
