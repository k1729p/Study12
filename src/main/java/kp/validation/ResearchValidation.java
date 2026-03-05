package kp.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import kp.validation.data.BoxCons;
import kp.validation.data.ItemCons;
import kp.validation.data.OperatorCons;
import kp.validation.data.impl.ItemConsImplCons;
import kp.validation.data.impl.ItemConsImplNoCons;

import java.awt.*;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * The validation research.
 * <p>
 * Bean validation is processed with Hibernate Validator.
 * </p>
 */
public class ResearchValidation {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    private static final ResearchValidationHelper researchValidationHelper = new ResearchValidationHelper();

    private static final List<String> DATA_FLD_RET = List.of("xxxxxx", "Fldxxx", "xxxRet", "FldRet");

    private static final String VALIDATED_VALUE = "Validated Value";
    private static final String CONSTRAINT_VIOLATION_ERROR_MSG = "Constraint Violation Error Message";
    private static final String[] VALIDATE_ITEM_HEADERS = {
            "Class Name", VALIDATED_VALUE, "Valid", CONSTRAINT_VIOLATION_ERROR_MSG
    };
    private static final int[] VALIDATE_ITEM_COL_W = {185, 95, 40, 200};
    private static final Dimension VALIDATE_ITEM_DIM = new Dimension(520, 200);

    private static final String[] VALIDATE_BOX_HEADERS = {
            "No.", "PropertyPath", VALIDATED_VALUE, CONSTRAINT_VIOLATION_ERROR_MSG
    };
    private static final int[] VALIDATE_BOX_COL_W = {35, 115, 95, 390};
    private static final Dimension VALIDATE_BOX_DIM = new Dimension(640, 115);

    private static final String[] VALIDATE_METHOD_HEADERS = {
            "Constraints Placed On", VALIDATED_VALUE, "Valid", CONSTRAINT_VIOLATION_ERROR_MSG
    };
    private static final int[] VALIDATE_METHOD_COL_W = {135, 95, 40, 350};
    private static final Dimension VALIDATE_METHOD_DIM = new Dimension(625, 85);

    private static final String[] EMPTY_ROW = new String[4];

    /**
     * Processes the validation.
     */
    public void process() {

        boolean loopFlag = true;
        while (loopFlag) {
            int chosenOption = researchValidationHelper.showButtons();
            switch (chosenOption) {
                case 0 -> validateItem();
                case 1 -> validateBoxOfItems();
                case 2 -> validateOperatorMethod();
                default -> loopFlag = false; // Go Back
            }
        }
    }

    /**
     * Validates the item.
     */
    private void validateItem() {

        final List<String[]> rowData = new ArrayList<>();
        for (String value : DATA_FLD_RET) {
            if (!value.equals(DATA_FLD_RET.getFirst())) {
                // adding spacer row
                rowData.add(EMPTY_ROW);
            }
            List.of(new ItemConsImplCons(), new ItemConsImplNoCons()).forEach(itemCons -> {
                itemCons.setVal(value);
                try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
                    final Validator validator = validatorFactory.getValidator();
                    final Set<ConstraintViolation<ItemCons>> violations = validator.validate(itemCons);
                    final String className = itemCons.getClass().getSimpleName();
                    readViolations(rowData, value, className, violations);
                }
            });
        }
        researchValidationHelper.showValidationResults(rowData, VALIDATE_ITEM_HEADERS, VALIDATE_ITEM_COL_W,
                VALIDATE_ITEM_DIM, ResearchValidationHelper.MENU_LIST.getFirst(), DATA_FLD_RET.toArray(String[]::new));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("validateItem()");
        }
    }

    /**
     * Reads the {@link ConstraintViolation}s.
     *
     * @param rowData    the rowData
     * @param value      the value
     * @param className  the name of the class
     * @param violations the violations
     */
    private <T> void readViolations(List<String[]> rowData, String value, String className,
                                    Set<ConstraintViolation<T>> violations) {

        if (violations.isEmpty()) {
            rowData.add(new String[]{className, value, "YES", ""});
            return;
        }
        for (ConstraintViolation<T> violation : violations) {
            rowData.add(
                    new String[]{className, violation.getInvalidValue().toString(), "NO", violation.getMessage()});
        }
    }

    /**
     * Validates the box of items.
     */
    private void validateBoxOfItems() {

        final List<String[]> rowData = new ArrayList<>();
        final BoxCons boxConsEmpty = new BoxCons(null, BigDecimal.ONE);
        validateBoxOfItems(boxConsEmpty, rowData, "1.");
        final List<ItemCons> list = new ArrayList<>();
        DATA_FLD_RET.forEach(val -> {
            final ItemConsImplCons itemConsImplCons = new ItemConsImplCons();
            itemConsImplCons.setVal(val);
            list.add(itemConsImplCons);
        });
        rowData.add(EMPTY_ROW);
        final BoxCons boxConsFull = new BoxCons(list, BigDecimal.TEN);
        validateBoxOfItems(boxConsFull, rowData, "2.");

        researchValidationHelper.showValidationResults(rowData, VALIDATE_BOX_HEADERS, VALIDATE_BOX_COL_W,
                VALIDATE_BOX_DIM, ResearchValidationHelper.MENU_LIST.get(1), DATA_FLD_RET.toArray(String[]::new));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("validateBoxOfItems()");
        }
    }

    /**
     * Validates the box of items.
     *
     * @param boxCons the boxCons
     * @param rowData the rowData
     * @param label   the label
     */
    private void validateBoxOfItems(BoxCons boxCons, List<String[]> rowData, String label) {

        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            final Map<String, List<ConstraintViolation<BoxCons>>> map = new TreeMap<>();
            validatorFactory.getValidator().validate(boxCons).forEach(violation -> {
                final String key = violation.getPropertyPath().toString();
                final List<ConstraintViolation<BoxCons>> list = map.getOrDefault(key, new ArrayList<>());
                list.add(violation);
                map.put(key, list);
            });
            final AtomicInteger atomic = new AtomicInteger();
            map.values().forEach(list ->
                    list.forEach(violation ->
                            readViolation(rowData, label, violation, atomic.incrementAndGet()))
            );
        }
    }

    /**
     * Reads the {@link ConstraintViolation}s.
     *
     * @param rowData   the rowData
     * @param label     the label
     * @param violation the violation
     * @param number    the number
     */
    private void readViolation(List<String[]> rowData, String label, ConstraintViolation<BoxCons> violation,
                               int number) {

        rowData.add(new String[]{label.concat(String.valueOf(number)),
                violation.getPropertyPath().toString(),
                Objects.nonNull(violation.getInvalidValue()) ? violation.getInvalidValue().toString() : "null",
                violation.getMessage()});
    }

    /**
     * Validates the method.
     */
    private void validateOperatorMethod() {

        checkExecution();
        Method method = null;
        try {
            method = OperatorCons.class.getMethod("process", Integer.class);
        } catch (NoSuchMethodException | SecurityException e) {
            logger.severe("validateOperatorMethod() Exception[%s]".formatted(e.getMessage()));
            System.exit(0);
        }
        final List<String[]> rowData = new ArrayList<>();
        validateMethodParameterValue(method, rowData);
        rowData.add(EMPTY_ROW);
        validateMethodReturnValue(method, rowData);
        researchValidationHelper.showValidationResults(rowData, VALIDATE_METHOD_HEADERS, VALIDATE_METHOD_COL_W,
                VALIDATE_METHOD_DIM, ResearchValidationHelper.MENU_LIST.get(2));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("validateOperatorMethod()");
        }
    }

    /**
     * Validates the parameter value of the method.
     *
     * @param method  the method
     * @param rowData the rowData
     */
    private void validateMethodParameterValue(Method method, List<String[]> rowData) {

        final OperatorCons operatorCons = new OperatorCons() {
        };
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            final ExecutableValidator executableValidator = validatorFactory.getValidator().forExecutables();
            IntStream.rangeClosed(1, 2).forEach(value -> {
                final Set<ConstraintViolation<OperatorCons>> violations = executableValidator.validateParameters(operatorCons,
                        method, new Integer[]{value}/*- parameter values */);
                readViolations(violations, rowData, "parameters", value);
            });
        }
    }

    /**
     * Validates the return value of the method.
     *
     * @param method  the method
     * @param rowData the rowData
     */
    private void validateMethodReturnValue(Method method, List<String[]> rowData) {

        final OperatorCons operatorCons = new OperatorCons() {
        };
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            final ExecutableValidator executableValidator = validatorFactory.getValidator().forExecutables();
            IntStream.rangeClosed(0, 1).forEach(value -> {
                final Set<ConstraintViolation<OperatorCons>> violations = executableValidator.validateReturnValue(operatorCons,
                        method, 2 - value /*- return value */);
                readViolations(violations, rowData, "return value", value);
            });
        }
    }

    /**
     * Reads the {@link ConstraintViolation}s.
     *
     * @param violations the violations
     * @param rowData    the rowData
     * @param label      the label
     * @param value      the value
     */
    private void readViolations(Set<ConstraintViolation<OperatorCons>> violations, List<String[]> rowData, String label,
                                int value) {

        if (violations.isEmpty()) {
            rowData.add(new String[]{label, String.valueOf(value), "YES", ""});
            return;
        }
        for (ConstraintViolation<OperatorCons> violation : violations) {
            rowData.add(new String[]{label, violation.getInvalidValue().toString(), "NO", violation.getMessage()});
        }
    }

    /**
     * Shows that the method with constraint violations is successfully executed.
     */
    private void checkExecution() {

        final OperatorCons operatorCons = new OperatorCons() {
        };
        operatorCons.process(0);
    }

}