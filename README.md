# Test project for ChromeDriver issue 2521
This project is a small test and demonstration project for the ChromeDriver issue [2521](https://bugs.chromium.org/p/chromedriver/issues/detail?id=2521) which
demonstrates, using two test cases, that the Chrome headless browser does not set a directory (or it's files) when
sending the path to a directory with sendKeys.

The used versions:
Chrome: 67.0.3396.99 64 bit
ChromeDriver: 2.40.565498 ea082db3280dd6843ebfb08a625e3eb905c4f5ab

A log file (with --verbose flag enabled) can be found in the `failed_verbose.log` file.
