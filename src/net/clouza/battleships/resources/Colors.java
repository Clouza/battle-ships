package net.clouza.battleships.resources;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */


/**
 * ANSI Escape Code (AEC)
 * Colors class refer to https://en.wikipedia.org/wiki/ANSI_escape_code
 * Colors scheme refer to https://en.wikipedia.org/wiki/ANSI_escape_code#Colors
 *
 * @SGR Select Graphic Rendition (SGR)
 * 0 = Normal Text
 * 1 = Bold
 * 3 = Italic
 * 4 = Underline
 * etc.
 *
 * @ESC ANSI escape sequences
 * ESC [
 * \033 stands for ESC
 *
 * @CSI Control Sequences Introducer(CSI)
 * CSI m (Sets colors and style of the characters following this code)
 * CSI ; (All common sequences just use the parameters as a series of semicolon-separated numbers)
 *
 * @e.g \033[SGR;ColorNumberAccordingTo(AEC)m
 *
 * @updated Last updated 11:00:56 PM (UTC+8 / WITA) Clouza.
 */
public class Colors {
    // Reset to normal
    public static final String NORMAL = "\033[0m";  // Normal color

    // Colors Available
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";
}
