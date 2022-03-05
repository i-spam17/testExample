package homeWork8;

import ru.yandex.qatools.allure.cucumberjvm.callback.OnFailureCallback;

public class FailureCallback implements OnFailureCallback {
    @Override
    public Object call() {
        return 10;
    }
}
