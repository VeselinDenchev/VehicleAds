package com.vehicleads.utils.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class RedirectToErrorPageUtil {

    public static String redirect(RedirectAttributes redirectAttributes,
                                  HttpStatus httpStatus,
                                  String message) {
        redirectAttributes.addFlashAttribute("ERROR_STATUS_CODE", httpStatus.value());
        redirectAttributes.addFlashAttribute("CUSTOM_ERROR_MESSAGE", message);

        return "redirect:/error";
    }
}
