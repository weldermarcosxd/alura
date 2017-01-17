<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'wordpress');

/** MySQL database username */
define('DB_USER', 'root');

/** MySQL database password */
define('DB_PASSWORD', 'root');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8mb4');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'I* 3xAyRv}Z@)`6_0ROWv+~Eh{6`rHK8lmEZ-)MwN2X<J+2?Hwh%zLsR)%3Uj=9<');
define('SECURE_AUTH_KEY',  'gyFuc&X%(}PJ5i4J/A<+J(CXEM!FBC+y&MP TxT+5[R!T[ut1;iQz@C67_Shq)Cf');
define('LOGGED_IN_KEY',    '&jRf_wY-587THj}L<V8;E!+fYDTBs#9&WiA~H=Slw6O8eUf.P>N3!t6{YHo8JmWs');
define('NONCE_KEY',        'ZnMtv,;aO#3dkk/)^!45y&Y1ZI5Tb4$ZX]uq4KooH}?l&wfps2*A39x}e8NFs]Y[');
define('AUTH_SALT',        'tQmg`c*T,WYHfe0VENV#&ND~Tk|+4A|ebmCZ9[C5ZDlQ+PpsV=HhDm}ou&D?Z7==');
define('SECURE_AUTH_SALT', 'Dm.MH6L09uwJ~}A@ 7xC81aFJi-NJP18NON}:mI#1wd^XZDj9Zctd?m(L ` QpeV');
define('LOGGED_IN_SALT',   'K?XDN=4B,eO6ljrC(q*t?JqeAdBV,}I(Zp .m3bFDtq$fpB/(gPe>30[pO6lz^cZ');
define('NONCE_SALT',       'A^{BK.>PivhQ1L<}>YOn^w[MilyFdk7?kND^|k.O4l<+w_GUW,HWp`g|.3bfU9tn');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the Codex.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
